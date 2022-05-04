package net.xdclass.xdvideo.controller;

/**
 * @program: xdvideo
 * @description: 微信相关
 * @packagename: net.xdclass.xdvideo.controller
 * @author: 姚泽宇
 * @date: 2022-05-04 15:14
 **/

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {
    @Autowired
    private WeChatConfig weChatConfig;

    @GetMapping("login_url")
    public JsonData loginUrl(@RequestParam(value = "access_page", required = true) String accessPage) throws UnsupportedEncodingException {
        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        String callbackUrl = URLEncoder.encode(redirectUrl, "GBK");
        String qrcodeUrl = String.format(weChatConfig.getOpenRedirectUrl(), weChatConfig.getOpenAppid(), callbackUrl, accessPage);
        return JsonData.buildSuccess(qrcodeUrl);
    }
}
