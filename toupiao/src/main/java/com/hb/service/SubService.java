package com.hb.service;

import com.hb.pojo.Sub;
import org.apache.ibatis.annotations.Param;

public interface SubService {
    int addSub(Sub sub);
    int bySubId();
    Sub bySubTitle(String title);
    int updateByType(Sub sub);
    int bySubIdDelete(Integer subId);
}
