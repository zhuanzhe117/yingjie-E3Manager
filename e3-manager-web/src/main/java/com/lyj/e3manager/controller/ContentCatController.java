package com.lyj.e3manager.controller;

import com.lyj.e3common.pojo.EasyUITreeNode;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.content.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ContentCatController {
    @Autowired
    private ContentCategoryService contentCategoryService;
    @RequestMapping("/content/category/list")
    @ResponseBody
    public List<EasyUITreeNode> getContentCatList(
            @RequestParam(name="id", defaultValue="0")int parentId) {
        List<EasyUITreeNode> list = contentCategoryService.getContentCatList(parentId);
        return list;
    }

    /**
     * 添加节点
     */
    @RequestMapping(value="/content/category/create", method= RequestMethod.POST)
    @ResponseBody
    public E3Result createContentCategory(int parentId, String name) {
        //调用服务添加节点
        E3Result e3Result = contentCategoryService.addContentCategory(parentId, name);
        return e3Result;
    }
}
