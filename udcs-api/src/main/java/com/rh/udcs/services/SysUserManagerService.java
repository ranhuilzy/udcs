package com.rh.udcs.services;

import com.rh.udcs.beans.SysUserInfoBean;

import java.util.List;

/**
 * Created by hui.ran on 2017/3/22.
 */
public interface SysUserManagerService {

    SysUserInfoBean getSysUserInfo(SysUserInfoBean userInfo);

    List<SysUserInfoBean> getSysUserList(SysUserInfoBean userInfo);
}
