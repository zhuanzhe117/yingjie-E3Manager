package com.lyj.e3manager.content.service.impl;

import com.lyj.e3common.jedis.JedisClient;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.content.service.ContentService;
import com.lyj.e3manager.dao.TbContentMapper;
import com.lyj.e3manager.entity.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;


public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${CONTENT_LIST}")
    private String CONTENT_LIST;

    @Override
    public E3Result addContent(TbContent content){
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);
        return E3Result.ok();
    }

    /**
     * 根据内容分类id查询内容列表
     * <p>Title: getContentListByCid</p>
     * <p>Description: </p>
     * @param cid
     * @return
     */
//    @Override
//    public List<TbContent> getContentListByCid(long cid) {
//        //查询缓存
//        try {
//            //如果缓存中有直接响应结果
//            String json = jedisClient.hget(CONTENT_LIST, cid + "");
//            if (StringUtils.isNotBlank(json)) {
//                List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
//                return list;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //如果没有查询数据库
//        TbContentExample example = new TbContentExample();
//        Criteria criteria = example.createCriteria();
//        //设置查询条件
//        criteria.andCategoryIdEqualTo(cid);
//        //执行查询
//        List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
//        //把结果添加到缓存
//        try {
//            jedisClient.hset(CONTENT_LIST, cid + "", JsonUtils.objectToJson(list));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
}
