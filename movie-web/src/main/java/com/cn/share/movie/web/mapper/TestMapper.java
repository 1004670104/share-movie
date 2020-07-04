package com.cn.share.movie.web.mapper;

import com.cn.share.movie.web.dao.Test;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    @Insert("insert into test(id) value(#{id})")
    int insert(Test test);
}
