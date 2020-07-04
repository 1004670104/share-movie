package com.cn.share.movie.web.service.impl;

import com.cn.share.movie.web.dao.Test;
import com.cn.share.movie.web.mapper.TestMapper;
import com.cn.share.movie.web.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public int insert(Test test) {
        int insert = testMapper.insert(test);
        return insert;
    }
}
