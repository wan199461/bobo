package com.wanbo.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;

public class App {
	
	
	public static void main(String[] args) {
		System.out.println("Begin");
		Set<RealMap> set = new TreeSet<RealMap>();
		RealMap[] map = new RealMap[3];
		for(int i = 0; i < map.length; i++) {
			map[i] = new RealMap(); 
		}
		map[1].setName("Wf");
		map[0].setAge(28);
		map[1].setAge(12);
		map[2].setAge(16);
		set.add(map[0]);
		set.add(map[1]);
		set.add(map[2]);
		System.out.println(JSON.toJSONString(set));
	}
	
	
	public static void doTest() {
		
		Map map = new LinkedHashMap<String, String>();
		
	}
	
	
	public static class RealMap implements Comparable{
		
		private String name;
		
		private Integer age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public int compareTo(Object o) {
			RealMap that = (RealMap)o;
			return this.age - that.age;
		}
		
	}

}
