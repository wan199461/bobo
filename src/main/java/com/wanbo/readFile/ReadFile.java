package com.wanbo.readFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
//		writeFile();
		readAndWriteFile();
	}
	
	
	private static void writeFile() throws IOException {
		
		 Date date=null;
		 date=new Date();
		 long start = date.getTime(); // milliseconds
		
		 String path="G:\\File\\text1.txt";
		 File file=new File(path);
		 OutputStream os = new FileOutputStream(file);
		 OutputStreamWriter ostream = new OutputStreamWriter(os);
		 BufferedWriter writer = new BufferedWriter(ostream);
		 
		 Cost c=new Cost();
		 Random r = new Random();
		 int i=100000;
		 while(0<i--) {
           Double max=r.nextDouble()*1000;
		   c.setInitMoney(max);
		   writer.write(JSON.toJSONString(c));
		   writer.newLine();
		 }
		 writer.close();
		 ostream.close();
		 os.close();
		 
		 date=new Date();
		 long end = date.getTime();
		 System.out.println("P1写入时间:"+(end-start)/1000+"秒");
		 
	}
	
	
	private static void readAndWriteFile() throws IOException {
		
		 Date date=null;
		 date=new Date();
		 long start = date.getTime(); // milliseconds
		 
		 String path="G:\\File\\text1.txt";
		 File file=new File(path);
		 FileInputStream istream = new FileInputStream(file);
		 Reader reader= new InputStreamReader(istream);
		 BufferedReader br = new BufferedReader(reader);
		 String tex=null;
		 
		 String path2="G:\\File\\text2.txt";
		 File file2=new File(path2);
		 OutputStream os = new FileOutputStream(file2);
		 OutputStreamWriter ostream = new OutputStreamWriter(os);
		 BufferedWriter writer = new BufferedWriter(ostream);
		 
		 List<Cost> li=new ArrayList<Cost>();
		 Random r = new Random();
		 while((tex=br.readLine())!=null) {
			Cost c = JSON.parseObject(tex, Cost.class);
			double init = c.getInitMoney();
			double rate = r.nextDouble();
			c.setRate(rate);
			double poundage = init*rate;
			c.setPoundage(poundage);
			c.setTerminalMoney(init-poundage);
			li.add(c);
		 }
		 br.close();
		 reader.close();
		 istream.close();
		 
		 
		 System.out.println("list长度："+li.size());		 
		 for(Cost c:li) {
			 writer.write(JSON.toJSONString(c));
			 writer.newLine();
		 }
		 writer.close();
		 ostream.close();
		 os.close();
		 
		 date=new Date();
		 long end = date.getTime();
		 System.out.println("P2写入花费时间:"+(end-start)/1000+"秒");
	}

}







