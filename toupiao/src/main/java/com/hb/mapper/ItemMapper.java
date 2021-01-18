package com.hb.mapper;

import com.hb.pojo.Item;
import com.hb.pojo.Option;
import com.hb.pojo.Sub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    List<Item> show(String title);//按条件查询

    List<Map> bySubId(Integer subId);

    List<Map> voteBySubId(Integer subId);

    int addVote(@Param("items") List<Item> items);

    Item byUserIdSubId(Integer userId,Integer subId);

    int delSubId(Integer subId);
}
