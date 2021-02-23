package com.lyj.e3manager.sso.service;

import com.lyj.e3common.utils.E3Result;
import com.lyj.e3manager.entity.TbUser;

public interface RegisterService {
    E3Result checkData(String param,int type);
    E3Result register(TbUser user);
}
