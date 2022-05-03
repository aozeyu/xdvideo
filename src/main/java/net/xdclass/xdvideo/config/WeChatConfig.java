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

	
}
