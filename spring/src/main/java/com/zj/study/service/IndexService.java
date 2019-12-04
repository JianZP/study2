package com.zj.study.service;

import com.zj.study.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
/*    @Autowired
            @Qualifier("indexDaoImpl")
    IndexDao indexDao;*/
@Autowired
TestService testService;
}
