package com.rh.udcs.web.controllers;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.rh.udcs.beans.SysUserInfoBean;
import com.rh.udcs.services.SysScheduleManagerService;
import com.rh.udcs.services.SysUserManagerService;
import io.spring.gradle.dependencymanagement.org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hui.ran on 2017/3/22.
 */

@Controller
public class AppUserController {
    protected  final static Logger logger= LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private SysUserManagerService userManagerService;

    @Autowired
    private SysScheduleManagerService scheduleManagerService;


    @Autowired
    private DefaultKaptcha captchaProducer;

    @RequestMapping("/userLogin")
    @ResponseBody
    public ModelMap sysLogin(HttpServletRequest request, @RequestParam(value="userName")String userName,
                             @RequestParam(value="pwd")String pwd,
                             @RequestParam(value="captcha")String captcha) throws Exception {
        ModelMap model=new ModelMap();
        HttpSession session=request.getSession(true);
        String captchaCod = (String)session.getAttribute(captchaProducer.getConfig().getSessionKey());
        if(StringUtils.isNotBlank(captchaCod)&&StringUtils.isNotBlank(captcha)&&(captchaCod.toLowerCase().equals(captcha.toLowerCase()))){
            SysUserInfoBean infoBean=null;
            if(StringUtils.isNotBlank(userName)){
                SysUserInfoBean userInfo=new SysUserInfoBean();
                userInfo.setUserName(userName);
                infoBean=userManagerService.getSysUserInfo(userInfo);
                try {
                    Assert.notNull(infoBean,"没有找到对应的用户信息");
                }catch (Exception ex){
                    model.put("code","00001");
                    model.put("msg","没有找到对应的用户信息");
                    return model;
                }
                if(StringUtils.isNotBlank(pwd)){
                    model.put("code","00001");
                    model.put("msg","输入密码不能为空");
                }else if(!pwd.toLowerCase().equals(infoBean.getPassword().toLowerCase())){
                    model.put("code","00001");
                    model.put("msg","输入密码不正确");
                }else{
                    model.put("code","0000");
                    model.put("msg","登录成功");
                }
            }else{
                model.put("code","00001");
                model.put("msg","输入用户名不能为空");
            }
            return model;
        }else{
            model.put("code","00001");
            model.put("msg","验证码错误");
            return model;
        }
    }
}
