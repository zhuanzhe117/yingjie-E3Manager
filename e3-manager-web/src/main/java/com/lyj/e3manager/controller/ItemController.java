package com.lyj.e3manager.controller;

import com.lyj.e3manager.entity.TbItem;
import com.lyj.e3manager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理Controller
 */
@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable int itemId){
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }
}
