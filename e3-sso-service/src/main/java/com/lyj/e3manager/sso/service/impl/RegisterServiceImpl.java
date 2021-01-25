package com.lyj.e3manager.sso.service.impl;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.dao.TbUserMapper;
import com.lyj.e3manager.entity.TbUser;
import com.lyj.e3manager.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户注册处理
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private TbUserMapper userMapper;
    @Override
    public E3Result checkData(String param,int type){
        //根据不同的type生成不同的查询条件
        TbUser user = new TbUser();
        //1：用户名 2：手机号 3：邮箱
        if (type == 1) {
       user.setUsername(param);
        } else if (type == 2) {
            user.setPhone(param);
        } else if (type == 3) {
            user.setEmail(param);
        } else {
            return E3Result.build(400, "数据类型错误");
        }
        //执行查询
        List<TbUser> list = userMapper.selectByExample(user);
        //判断结果中是否包含数据
        if (list != null && list.size()>0) {
            //如果有数据返回false
            return E3Result.ok(false);
        }
        //如果没有数据返回true
        return E3Result.ok(true);
    }
}
