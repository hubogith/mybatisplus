package com.hb.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hb.mapper.ProductsMapper;
import com.hb.pojo.Products;
import com.hb.service.ProductsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements ProductsService {
}
