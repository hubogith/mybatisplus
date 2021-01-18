package com.hb.service;

import com.hb.pojo.Option;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OptionService {
    //批量新增
    int optionAdd(List<Option> options);
    //批量删除
    int  deleteOid(@Param("list0")List<Integer> list0);
    //批量修改
    int updateOid(@Param("options") List<Option> options);
    int bySubIdDelete(Integer subId);
}
