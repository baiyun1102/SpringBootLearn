package com.test.hazelcast.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @ClassName HzTestController
 * @author xdcui
 * @创建时间 2018-05-29 14:17:05
 * @说明：
 */
@RestController
public class HzTestController2 {

	private static final Logger log = LoggerFactory.getLogger(HzTestController2.class);
	//PrintAllMember  
	public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        Map<String, String> map = hz.getMap("map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        while(true){
            System.out.println("--size:"+map.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    
}