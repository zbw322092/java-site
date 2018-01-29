package com.javasite.service;

import com.javasite.common.ServerResponse;
import com.javasite.pojo.Product;
import com.javasite.vo.ProductDetailVo;

public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    public ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);
}
