package com.lyj.e3manager.order.service.impl;

import com.lyj.e3common.jedis.JedisClientPool;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.dao.TbOrderItemMapper;
import com.lyj.e3manager.dao.TbOrderMapper;
import com.lyj.e3manager.dao.TbOrderShippingMapper;
import com.lyj.e3manager.entity.TbOrderItem;
import com.lyj.e3manager.entity.TbOrderShipping;
import com.lyj.e3manager.order.pojo.OrderInfo;
import com.lyj.e3manager.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单服务处理
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private TbOrderMapper orderMapper;
    @Autowired
    private TbOrderItemMapper orderItemMapper;
    @Autowired
    private TbOrderShippingMapper orderShippingMapper;
    @Autowired
    private JedisClientPool jedisClientPool;
    @Value("${ORDER_ID_GEN_KEY}")
    private String ORDER_ID_GEN_KEY;
    @Value("${ORDER_ID_START}")
    private String ORDER_ID_START;
    @Value("${ORDER_DETAIL_ID_GEN_KEY}")
    private String ORDER_DETAIL_ID_GEN_KEY;
    @Override
    public E3Result createOrder(OrderInfo orderInfo) {
        //生成订单号。使用redis的incr生成。
        if (!jedisClientPool.exists(ORDER_ID_GEN_KEY)) {
            jedisClientPool.set(ORDER_ID_GEN_KEY, ORDER_ID_START);
        }
        String orderId = jedisClientPool.incr(ORDER_ID_GEN_KEY).toString();
        //补全orderInfo的属性
        orderInfo.setOrderId(orderId);
        //1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        orderInfo.setStatus(1);
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        //插入订单表
        orderMapper.insert(orderInfo);
        //向订单明细表插入数据。
        List<TbOrderItem> orderItems = orderInfo.getOrderItems();
        for (TbOrderItem tbOrderItem : orderItems) {
            //生成明细id
            String odId = jedisClientPool.incr(ORDER_DETAIL_ID_GEN_KEY).toString();
            //补全pojo的属性
            tbOrderItem.setId(odId);
            tbOrderItem.setOrderId(orderId);
            //向明细表插入数据
            orderItemMapper.insert(tbOrderItem);
        }
        //向订单物流表插入数据
        TbOrderShipping orderShipping = orderInfo.getOrderShipping();
        orderShipping.setOrderId(orderId);
        orderShipping.setCreated(new Date());
        orderShipping.setUpdated(new Date());
        orderShippingMapper.insert(orderShipping);
        //返回E3Result，包含订单号
        return E3Result.ok(orderId);
    }
}
