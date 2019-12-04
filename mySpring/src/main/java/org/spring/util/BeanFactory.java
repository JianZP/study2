package org.spring.util;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BeanFactory {
    Map<String,Object> map=new HashMap<String,Object>();
    public BeanFactory(String xml) {
        parseXml(xml);
    }
    public void parseXml(String xml)throws ZjSpringException{
        File file=new File(this.getClass().getResource("/").getPath()+"//"+xml);
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(file);
           Element rootElement= document.getRootElement();
           Attribute attribute = rootElement.attribute("default");
           boolean flag=false;
           if (attribute!=null){
                flag=true;
           }
//         List<Element> allChild= rootElement.elements();
            for (Iterator<Element> itFirst = rootElement.elementIterator(); itFirst.hasNext();) {
                //1.实例化对象
                Element eleFirstChild = itFirst.next();
                //获得对象，将xml获取的对象存放于map中
                Attribute attributeId=eleFirstChild.attribute("id");
                String beanName= attributeId.getValue();
                Attribute attributeClass=eleFirstChild.attribute("class");
                String clazzName= attributeClass.getValue();
                Class clazz= Class.forName(clazzName);
//               Object object=clazz.newInstance();
               //2.维护依赖关系，看这个对象有没有依赖（判断是否有property属性，或者判断类是否有属性）
                //如果有则注入
                Object object=null;
                for (Iterator<Element> itSecond = eleFirstChild.elementIterator(); itSecond.hasNext();) {
                    //得到ref的value，通过value得到对象（map）
                    //得到name的值,人后根据值获取一个Filed的对象
                    //通过Field的set方法set那个对象
                    Element eleSecondChild=itSecond.next();
                   if (eleSecondChild.getName().equals("property")){
                       //由于是setter方法，没有特殊的构造方法
                     object=clazz.newInstance();
                     Object injetObject = map.get( eleSecondChild.attribute("ref").getValue());
                     String nameValue= eleSecondChild.attribute("name").getValue();
                     Field field=clazz.getDeclaredField(nameValue);
                     //设置值可以被调用
                     field.setAccessible(true);
                     field.set(object,injetObject);
                   }else if(eleSecondChild.getName().equals("constructor-arg")){//证明有特殊构造方法
                       Object injetObject = map.get( eleSecondChild.attribute("ref").getValue());
                      Class injectObjectClazz= injetObject.getClass();
                     Constructor constructor= clazz.getConstructor(injectObjectClazz.getInterfaces()[0]);
                       object=constructor.newInstance(injetObject);
                   }

                }
                if (object==null) {
                    if (flag) {
                        if (attribute.getValue().equals("byType")) {
                            //判断是否有依赖，如果有依赖就通过byType注入
                            Field fields[] = clazz.getDeclaredFields();
                            for (Field field : fields) {
                                //得到属性的类型，比如UserDao userDao;那么这里的field.getType()就等于UserDao.class
                                Class injectObjectClazz = field.getType();
                                //由于是byType 所以需要遍历map中的所有对象，判断对象类型是不是和injectObjectClazz相同
                                int count = 0;
                                Object injectObject = null;
                                for (String key : map.keySet()) {
                                    Class temp = map.get(key).getClass().getInterfaces()[0];
                                    if (temp.getName().equals(injectObjectClazz.getName())) {
                                        injectObject = map.get(key);
                                        //记录找到一个，因为可能找到多个
                                        count++;

                                    }
                                }
                                if (count > 1) {
                                    throw new ZjSpringException("需要一个对象，但是找到了多个");
                                } else {
                                    object = clazz.newInstance();
                                    field.setAccessible(true);
                                    field.set(object, injectObject);
                                }
                            }
                        }
                    }
                }
                if (object==null){//没有子标签
                    object=clazz.newInstance();
                }
               map.put(beanName,object);
                // do something
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
    public Object getBean(String beanName){
        return map.get(beanName);
    }
}
