package com.hb.ItemServiceimpl;

import com.hb.mapper.OptionMapper;
import com.hb.pojo.Option;
import com.hb.service.OptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OptionServiceImpl implements OptionService {

    @Resource
    private OptionMapper optionMapper;

    @Transactional
    @Override
    public int optionAdd(List<Option> options) {

        return optionMapper.optionAdd(options);
    }

    @Override
    public int deleteOid(List<Integer> list0) {
        return optionMapper.deleteOid(list0);
    }

    @Override
    public int updateOid(List<Option> options) {
        return optionMapper.updateOid(options);
    }

    @Override
    public int bySubIdDelete(Integer subId) {
        return optionMapper.delSubId(subId);
    }
}
