package com.lyj.e3manager.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyj.e3common.jedis.JedisClient;
import com.lyj.e3common.pojo.EasyUIDataGridResult;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3common.utils.IDUtils;
import com.lyj.e3common.utils.JsonUtils;
import com.lyj.e3manager.dao.TbItemDao;
import com.lyj.e3manager.dao.TbItemDescMapper;
import com.lyj.e3manager.entity.TbItemDesc;
import com.lyj.e3manager.service.ItemService;
import com.lyj.e3manager.entity.TbItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Destination;
import java.util.Date;
import java.util.List;

/**
 * 商品管理Service
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemDao tbItemDao;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination topicDestination;
    @Autowired
    private JedisClient jedisClientPool;

    @Value("${REDIS_ITEM_PRE}")
    private String REDIS_ITEM_PRE;
    @Value("${ITEM_CACHE_EXPIRE}")
    private Integer ITEM_CACHE_EXPIRE;

    /**
     * 根据商品id取商品信息
     * @param itemId
     * @return
     */
    @Override
    public TbItem getItemById(int itemId){
        // 根据主键查询
        TbItem item = tbItemDao.queryById(itemId);
        return  null;
    }


    @Override
    public EasyUIDataGridResult getItemList(int page, int rows){
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItem tbItem = new TbItem();
        List<TbItem> list = tbItemDao.queryAll(tbItem);
        //创建一个返回值对象
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(list);
        //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //取总记录数
        long total = pageInfo.getTotal();
        result.setTotal(total);
        return result;
    }

    @Override
    public E3Result addItem(TbItem item,String desc){
        //生成商品id
        final long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //1-正常，2-下架，3-删除
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        tbItemDao.insert(item);
        //创建一个商品描述表对应的pojo对象。
        TbItemDesc itemDesc = new TbItemDesc();
        //补全属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setCreated(new Date());
        itemDesc.setUpdated(new Date());
        //向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //发送商品添加消息
        jmsTemplate.send(topicDestination, new MessageCreator() {

            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(itemId +"");
                return textMessage;
            }
        });
        //返回成功
        return E3Result.ok();
    }

    @Override
    public TbItemDesc getItemDescById(long itemId){
        //查询缓存
        try {
            String json = jedisClientPool.get(REDIS_ITEM_PRE + ":" + itemId + ":DESC");
            if(StringUtils.isNotBlank(json)) {
                TbItemDesc tbItemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
                return tbItemDesc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);

        //把结果添加到缓存
        try {
            jedisClientPool.set(REDIS_ITEM_PRE + ":" + itemId + ":DESC", JsonUtils.objectToJson(itemDesc));
            //设置过期时间
            jedisClientPool.expire(REDIS_ITEM_PRE + ":" + itemId + ":DESC", ITEM_CACHE_EXPIRE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemDesc;
    }
}
