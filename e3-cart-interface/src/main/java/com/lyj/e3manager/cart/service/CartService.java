package com.lyj.e3manager.cart.service;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.entity.TbItem;

import java.util.List;

public interface CartService {
    E3Result addCart(long userId,long itemId,int num);
    //合并购物车
    E3Result mergeCart(long userId, List<TbItem> itemList);
    //取购物车列表
    List<TbItem> getCartList(long userId);
    //更新购物车数量
    E3Result updateCartNum(long userId,long itemId,int num);
    //删除购物商品
    E3Result deleteCartItem(long userId,long itemId);
}
