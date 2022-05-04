package net.xdclass.xdvideo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySource(value = "classpath:application.properties")
@Data
public class WeChatConfig {
	@Value("${wxpay.appid}")
	private String appid;
	
	@Value("${wxpay.appsecret}")
	private String appsecret;

	@Value("${wxopen.appid}")
	private String openAppid;
	@Value("${wxopen.appsecret}")
	private String openAppsecret;
	@Value("${wxopen.redirect_url}")
	private String openRedirectUrl;
	private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";
}
