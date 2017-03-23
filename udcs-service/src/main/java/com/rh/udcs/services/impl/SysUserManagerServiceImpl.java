package com.rh.udcs.services.impl;

import com.rh.udcs.beans.SysUserInfoBean;
import com.rh.udcs.services.SysUserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hui.ran on 2017/3/22.
 */
@Service("userManagerService")
public class SysUserManagerServiceImpl implements SysUserManagerService {
    protected  final static Logger logger= LoggerFactory.getLogger(SysUserManagerServiceImpl.class);

    @Override
    public SysUserInfoBean getSysUserInfo(SysUserInfoBean userInfo) {
        return null;
    }

    @Override
    public List<SysUserInfoBean> getSysUserList(SysUserInfoBean userInfo) {
        return null;
    }
}
