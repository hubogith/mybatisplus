package com.hb.service.impl;

import com.hb.pojo.Products;
import com.hb.mapper.ProductsMapper;
import com.hb.service.ProductsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 波
 * @since 2020-12-13
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {

}
