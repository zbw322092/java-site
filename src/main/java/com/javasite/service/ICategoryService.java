package com.javasite.service;

import com.javasite.common.ServerResponse;
import com.javasite.pojo.Category;

import java.util.List;

public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> getCategoryAndDeepChildrenCategory(Integer categoryId);
}
