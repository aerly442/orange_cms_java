package com.gfrjxz.cms.dao;

import com.gfrjxz.cms.entity.*;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.*;

public interface NewsSourceDao extends BaseMapper<NewsSource> {
  
    //@Select("select * from user where id>#{id}")
    //List<User> getList(@Param("id") int id);

}
