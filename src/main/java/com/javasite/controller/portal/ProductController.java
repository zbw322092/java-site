package com.javasite.controller.portal;

import com.github.pagehelper.PageInfo;
import com.javasite.common.ServerResponse;
import com.javasite.service.IProductService;
import com.javasite.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(Integer productId) {
        return iProductService.getProductDetail(productId);
    }

    public ServerResponse<PageInfo> list(@RequestParam(value="keyword", required = false) String keyword,
                                         @RequestParam(value="categoryId", required = false) Integer categoryId,
                                         @RequestParam(value="pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value="pageSize", defaultValue = "10") int pageSize,
                                         @RequestParam(value="orderBy", defaultValue = "") String orderBy) {
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }
}
