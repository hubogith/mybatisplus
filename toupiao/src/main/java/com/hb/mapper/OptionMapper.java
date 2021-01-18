package com.hb.mapper;

import com.hb.pojo.Option;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionMapper {
    int optionAdd(@Param("options")List<Option> options);
    int  deleteOid(@Param("list0")List<Integer> list0);
    int updateOid(@Param("options") List<Option> options);
    int delSubId(Integer subId);
}
