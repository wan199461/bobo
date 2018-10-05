package com.wanbo;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MyDefaultException
    {
    	/**
    	 *  测试1
    	 */
        List<String> list=new ArrayList<String>();
        addList(list);
        list.add("Lo");
        for(String li:list) {
        	System.out.println(li);
        }
        
        
        
        /**
         * 测试2
         */
        App a=new App();
        List<String> list2=new ArrayList<String>();
        list2.add("Lo");
        a.addList2(list2);
        for(String li:list2) {
        	System.out.println(li);
        }
        
        
        /**
         * 测试3
         */
        DataBean bean=new DataBean();
        bean.age=1;
        bean.name="1";
        bean.len=1;
        App app3=new App();
        changeBean(bean);
        System.out.println("Age:="+bean.age);
    }
    
    public static void changeBean(DataBean bean) {
    	bean.age=2;
    	bean.name="2";
    	bean.len=2;
    }
    
    public  static void addList(List<String> list) {
    	 list.add("HEl");
    }
    
    public void addList2(List<String> list) {
    	 list.add("Li");
    }
    
    
    
}












