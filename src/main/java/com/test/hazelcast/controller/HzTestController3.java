package com.test.hazelcast.controller;

import java.util.Map;
import java.util.Queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @ClassName HzTestController
 * @author xdcui
 * @创建时间 2018-05-29 14:17:05
 * @说明：
 */
public class HzTestController3 {
	
	//PrintAllMember  
	 public static void main(String[] args) {
	        //创建一个 hazelcastInstance实例
	        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
	        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
	        Map<String, String> map = hz.getMap("map");
	        Map<Integer, String> clusterMap = instance.getMap("map");
	        Queue<String> clusterQueue = instance.getQueue("MyQueue");
	        
	        System.out.println("Map Value:" + clusterMap.get(1));
	        System.out.println("Queue Size :" + clusterQueue.size());
	        System.out.println("Queue Value 1:" + clusterQueue.poll());
	        System.out.println("Queue Value 2:" + clusterQueue.poll());
	        System.out.println("Queue Size :" + clusterQueue.size());
	    }
    
    
}