package com.javasite.service;

import com.github.pagehelper.PageInfo;
import com.javasite.common.ServerResponse;
import com.javasite.pojo.Product;
import com.javasite.vo.ProductDetailVo;

public interface IProductService {

    ServerResponse saveOrUpdateProduct(Product product);

    public ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);
}
