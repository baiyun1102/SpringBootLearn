package com.test.mongodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName ： TestController
 * @author xdcui
 * 创建于 2018年5月3日 下午5:40:45
 * 说明：
 */
@RestController
public class MbTestController {

	private static final Logger log = LoggerFactory.getLogger(MbTestController.class);
	
    @GetMapping("/testmb")
    public String helloworld() {
    	log.trace("logback的--trace日志--输出了");
    	log.debug("logback的--debug日志--输出了");
    	log.info("logback的--info日志--输出了");
    	log.warn("logback的--warn日志--输出了");
    	log.error("logback的--error日志--输出了");
        return "helloworld";
    }
    
    
}