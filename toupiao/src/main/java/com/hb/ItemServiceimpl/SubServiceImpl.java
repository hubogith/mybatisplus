package com.hb.ItemServiceimpl;

import com.hb.mapper.SubMapper;
import com.hb.pojo.Sub;
import com.hb.service.SubService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Year;

@Service
public class SubServiceImpl implements SubService {

    @Resource
    private SubMapper subMapper;

    @Transactional
    @Override
    public int addSub(Sub sub) {
        return subMapper.addSub(sub);
    }
    @Override
    public int bySubId() {
        return subMapper.bySubId();
    }

    @Override
    public Sub bySubTitle(String title) {

        return subMapper.bySubTitle(title);
    }

    @Override
    public int updateByType(Sub sub) {
        return subMapper.updateByType(sub);
    }

    @Override
    public int bySubIdDelete(Integer subId) {
        return subMapper.delSubId(subId);
    }
}
