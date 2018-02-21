package com.javasite.service;

import com.javasite.common.ServerResponse;

public interface IOrderService {
    ServerResponse pay(Long orderNo, Integer userId, String path);
}
