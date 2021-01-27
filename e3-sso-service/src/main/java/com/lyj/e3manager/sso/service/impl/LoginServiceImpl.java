package com.lyj.e3manager.sso.service.impl;

import com.lyj.e3common.jedis.JedisClient;
import com.lyj.e3common.utils.E3Result;
import com.lyj.e3common.utils.JsonUtils;
import com.lyj.e3manager.dao.TbUserMapper;
import com.lyj.e3manager.entity.TbUser;
import com.lyj.e3manager.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    JedisClient jedisClientPool;
    @Value("${SESSION_EXPIRE}")
    private Integer SESSION_EXPIRE;

    @Override
    public E3Result userLogin(String username,String password){
        // 1、判断用户和密码是否正确
        //根据用户名查询用户信息
        TbUser user = new TbUser();
        user.setUsername(username);
        //执行查询
        List<TbUser> list = userMapper.selectByExample(user);
        if (list == null || list.size() == 0) {
            //返回登录失败
            return E3Result.build(400, "用户名或密码错误");
        }
        //取用户信息
        TbUser users = list.get(0);
        //判断密码是否正确
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(users.getPassword())) {
            // 2、如果不正确，返回登录失败
            return E3Result.build(400, "用户名或密码错误");
        }
        // 3、如果正确生成token。
        String token = UUID.randomUUID().toString();
        // 4、把用户信息写入redis，key：token value：用户信息
        users.setPassword(null);
        jedisClientPool.set("SESSION:" + token, JsonUtils.objectToJson(users));
        // 5、设置Session的过期时间
        jedisClientPool.expire("SESSION:" + token, SESSION_EXPIRE);
        // 6、把token返回

        return E3Result.ok(token);
    }
}
