package com.zj.Proxy;

import com.zj.dao.CustomInvocationHandler;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {
    public static Object newInstance(Class targetInf, CustomInvocationHandler h){
       // String handler=h.getClass().getSimpleName();
        Object proxy=null;
//        Class targetInf=target.getClass().getInterfaces()[0];
        Method methods[]=targetInf.getDeclaredMethods();
        String line="\n";
        String tab="\t";
        String infName=targetInf.getSimpleName();
        String content="";
        String packageContent="package com.google;"+line;
        String importContent="import "+targetInf.getName()+";"+line
                +"import com.zj.dao.CustomInvocationHandler;"+line
                +"import java.lang.reflect.Method;"+line
                +"import java.lang.Exception;"+line;
        String clazzFirstLineContent="public class $Proxy implements "+infName+"{"+line;
        String filedContent=tab+"private CustomInvocationHandler h;"+line;
        //String constructorContent="";
        String constructorContent = tab+"public $Proxy(CustomInvocationHandler h){"+line
                +tab+tab+"this.h=h;"
                +line+tab+"}"+line;
        String methodContent="";
        for (Method method:methods){
            String returnTypeName=method.getReturnType().getSimpleName();
            String methodName=method.getName();
            Class args[]=method.getParameterTypes();
            String argsContent="";
            String paramsContent="";
            int flag=0;
            for (Class arg:args){
                String temp=arg.getSimpleName();
                argsContent+=temp+" p"+flag+",";
                paramsContent+="p"+flag+",";
                flag++;
            }
            if(argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
            }
            methodContent+=tab+tab+"public "+returnTypeName+" "+methodName+"("+argsContent+")throws Exception{"+line
                    +tab+tab+"Method method=Class.forName(\""+targetInf.getName()+"\").getDeclaredMethod(\""+methodName+"\"); "+line
                    +tab+tab+"return ("+returnTypeName+")h.invoke(method);"+line
                    +tab+"}"+line;
                   /* if(returnTypeName.equals("void")){
                        methodContent+=tab+tab+"target."+methodName+"("+paramsContent+");"+line
                                +tab+"}"+line;
                    }else{
                        methodContent+=tab+tab+"return target."+methodName+"("+paramsContent+");"+line
                                +tab+"}"+line;
                    }*/

        }
        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";
        File file=new File("F:\\com\\google\\$Proxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw=new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();
            URL[] urls = new URL[]{new URL("file:F:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");
            Constructor constructor=clazz.getConstructor(CustomInvocationHandler.class);
            //return  clazz.newInstance();
            proxy=constructor.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proxy;
    }
}
