package com.lyj.e3manager.order.service;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.order.pojo.OrderInfo;

public interface OrderService {
    E3Result createOrder(OrderInfo orderInfo);
}
