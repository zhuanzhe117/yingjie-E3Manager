package com.lyj.e3manager.sso.service;

import com.lyj.e3common.utils.E3Result;

public interface LoginService {
    E3Result userLogin(String username,String password);
}
