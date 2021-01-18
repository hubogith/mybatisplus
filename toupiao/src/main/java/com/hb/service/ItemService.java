package com.hb.service;

import com.hb.pojo.Item;
import com.hb.pojo.Sub;

import java.util.List;
import java.util.Map;


public interface ItemService {
    List<Item> show(String title);
    List<Map> bySubId(Integer subId);
    List<Map> voteBySubId(Integer subId);
    int addVote(List<Item> items);
    Item byUserIdSubId(Integer userId,Integer subId);
    int bySubIdDelete(Integer subId);
}
