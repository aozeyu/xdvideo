package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.xdclass.xdvideo.config.WeChatConfig;

@RestController
public class TestController {
	@Autowired
	private WeChatConfig weChatConfig;
	@Autowired
	private VideoMapper videoMapper;
	@RequestMapping("test_config")
	public String testConfig() {
		return weChatConfig.getAppid();
	}
	@RequestMapping("test_db")
	public Object testDb() {
		return videoMapper.findAll();
	}
	
}
