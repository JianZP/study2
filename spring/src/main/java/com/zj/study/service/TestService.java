package com.zj.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    IndexService indexService;
}
