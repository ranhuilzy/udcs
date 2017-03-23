package com.rh.udcs.web.controllers;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by hui.ran on 2017/3/20.
 */
@Controller
public class AppHomeController {

    protected  final static Logger logger= LoggerFactory.getLogger(AppHomeController.class);

    @Autowired
    private DefaultKaptcha captchaProducer;

    @RequestMapping("/kaptchaImage")
    public void getKaptchaImage(HttpServletRequest request,
                                        HttpServletResponse response) throws Exception {
        HttpSession session=request.getSession(true);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
                "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        System.out.println("capText: " + capText);
        try {
            session.setAttribute(captchaProducer.getConfig().getSessionKey(),capText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "png", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
