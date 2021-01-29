package com.lyj.e3manager.sso.service;

import com.lyj.e3common.utils.E3Result;

/**
 * 根据token查询用户信息
 */
public interface TokenService {
    E3Result getUserByToken(String token);
}
