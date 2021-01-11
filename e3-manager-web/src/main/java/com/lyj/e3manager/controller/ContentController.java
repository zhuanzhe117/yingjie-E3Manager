package com.lyj.e3manager.controller;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.content.service.ContentService;
import com.lyj.e3manager.entity.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 */
@Controller
public class ContentController {
    @Autowired
    private ContentService contentService;

    @RequestMapping(value="/content/save", method= RequestMethod.POST)
    @ResponseBody
    public E3Result addContent(TbContent content) {
        //调用服务把内容数据保存到数据库
        E3Result e3Result = contentService.addContent(content);
        return e3Result;
    }
}
