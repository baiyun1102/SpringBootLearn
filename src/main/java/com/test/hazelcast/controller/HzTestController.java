package com.test.hazelcast.controller;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HzTestController {

	private static final Logger log = LoggerFactory.getLogger(HzTestController.class);
	//FillMapMember 
    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        Map<String, String> map = hz.getMap("map");
        map.put("1", "Tokyo");
        map.put("2", "Paris");
        map.put("3", "New York");
        System.out.println("Finished loading map：");
        while(true){
            String key=Double.toString((int)(Math.random()*100000/1));
            String value="v-"+key.substring(0, 4);
            map.put(key, value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Add：<"+key+" : "+value+">");
        }
    }
    
    
    @GetMapping("/getHz")
    public String getHz() {
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
        
        //return "ok";
    }
    
    /*@GetMapping("/getHz")
    public void getHz() {
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
    }*/
    
}