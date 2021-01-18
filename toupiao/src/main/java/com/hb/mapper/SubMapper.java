package com.hb.mapper;

import com.hb.pojo.Sub;
import org.apache.ibatis.annotations.Param;

public interface SubMapper {
    int addSub(@Param("sub") Sub sub);
    int bySubId();
    //根据主题标题查
    Sub bySubTitle(String title);
    //修改主题类型
    int updateByType(@Param("sub")Sub sub);
    //删除主题
    int delSubId(Integer subId);
}
