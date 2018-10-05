package com.wanbo;

import com.alibaba.fastjson.JSON;

public class App1 {
	
     public static void main(String[] args) {
    	 String msg = "awe";
    	 getMaxSizeFromString(msg.toCharArray());
     }



public static void getMaxSizeFromString(char[] str){
    int maxSize = 0;
    int record[] = new int[26];
	for(int i=0;i<str.length;i++){
	    record = reSetRecoder(record);   // init
	    for(int j=i; j<str.length;j++){
		   int temp = str[j] - 'a'; 
		   if(record[temp] == 0){  record[temp] = 1;  continue; }
		   if(record[temp] == 1){
		      int size = findSize(record);
			  maxSize = maxSize>=size?maxSize:size;
			  break;
		   }
		}
	    int size = findSize(record);
	    maxSize = maxSize>=size?maxSize:size;
	}
	
	System.out.println("MaxSize:" + maxSize);
}

	public static int[] reSetRecoder(int[] a){
	      for(int i=0; i<a.length; i++){
		      a[i] = 0;
		  }
		  return a;
	}
	
	public static int findSize(int[] a){
	      int size = 0;
	       for(int i=0; i<a.length; i++){
		       if(a[i] == 1){  size++;  }
		   }
	    System.out.println(size);
	    return size;
	}

     
}
