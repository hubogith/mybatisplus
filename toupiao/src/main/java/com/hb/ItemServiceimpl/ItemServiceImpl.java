package com.hb.ItemServiceimpl;

import com.github.pagehelper.PageHelper;
import com.hb.mapper.ItemMapper;
import com.hb.pojo.Item;
import com.hb.pojo.Sub;
import com.hb.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;



    @Override
    public List<Item> show(String title) {
        System.out.println("进来了");
        List<Item> show = itemMapper.show(title);
        for (Item item : show) {
            System.out.println(item);
        }
        return show;
    }

    @Override
    public List<Map> bySubId(Integer subId) {
        List<Map> list= itemMapper.bySubId(subId);
        return list;
    }

    @Override
    public List<Map> voteBySubId(Integer subId) {
        List<Map> maps = itemMapper.voteBySubId(subId);
        return maps;
    }

    @Transactional
    @Override
    public int addVote(List<Item> items) {
        int num = itemMapper.addVote(items);
        return num;
    }

    @Override
    public Item byUserIdSubId(Integer userId, Integer subId) {
        return itemMapper.byUserIdSubId(userId,subId);
    }

    @Override
    public int bySubIdDelete(Integer subId) {
        return itemMapper.delSubId(subId);
    }
}
