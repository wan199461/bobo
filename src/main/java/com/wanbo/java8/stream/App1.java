package com.wanbo.java8.stream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.security.auth.kerberos.KerberosKey;
import javax.security.auth.x500.X500Principal;
import javax.sql.RowSet;
import com.alibaba.fastjson.JSON;

public class App1 {

  public static void main(String... args) throws Exception {

//    ListStream(args);
    
//      MapStream(args);
    
//      reduceStream(args);

//      mapStream();

       doLocalDate();
  }

  private static void ListStream(String... args) throws Exception {
    BufferedOutputStream bos = new BufferedOutputStream(System.out);
    bos.write(args[0].getBytes());
    bos.write("\n".getBytes());
    bos.flush();

    List<String> infos = Arrays.asList("9", "4", "1", "3", "8", "7", "5");

    Stream info2 = infos.stream().filter(new Predicate() {
      @Override
      public boolean test(Object t) {
        if ("3".equals(t)) {
          return false;
        }
        return true;
      }
    });

    info2.forEach(new Consumer() {
      @Override
      public void accept(Object t) {
        try {
          bos.write(t.toString().getBytes());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    bos.write("     --------  \n".getBytes());
    bos.flush();


    Stream<String> iStream = infos.stream().filter(e -> {
      if (e.compareTo("3") > 0) {
        return true;
      }
      return false;
    });
    iStream.forEach(System.out::print); // 1. Stream.forEach用函数接口接受一个方法
                                        // 2. System.out获取到控制台输入流对象，用::关键字将对象的print方法传入

    System.out.println("............................");

    Stream<String> iStream1 = infos.stream().filter(App1::filt); // 直接传入静态方法
    iStream1.forEach(System.out::print);
    

  }

  
  private static void MapStream(String... args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("1z", 1);
    map.put("2s", 2);
    map.put("3f", 3);
    map.put("4q", 4);
    map.put("5b", 5);
    map.put("6y", 6);
    map.put("7j", 7);
    map.put("8c", 8);
    map.forEach((k,v) ->{System.out.print("key" + k); System.out.print("  val:" + v + "\n");});
    
//    System.out.println(JSON.toJSONString(map));
    
    HashSet<String> set = new HashSet<String>();
    set.add("b2");
    set.add("B2");
    set.add("a1");
    set.add("A1");
    set.forEach(e->{System.out.println(e + "  "); });
    
    System.out.println(".....................");
    HashSet<String> set2 = new HashSet<String>();
    set2.add("A1");
    set2.add("B2");
    set2.add("b2");
    set2.add("a1");
    set2.forEach(e->{System.out.println(e + "  "); }); 
    
  }
  
  
  private static void reduceStream(String... strings) {
    List<Integer> datas = Arrays.asList(2, 5, 6, 7, 4, 9, 1);

    datas.stream().reduce((x, y) -> {
      System.out.println("X:" + x + "  Y:" + y);
      return x+y;
    });
  }
  
  private static void mapStream(String...strings) {
    List<String> datas = Arrays.asList("i", "fN", "gYm");
    datas.stream().map(String::toUpperCase).forEach(System.out::print);  //  为什么可以用String::toUpperCase ???
    
//    datas.stream().map(new Function<String, String>() {
//
//      @Override
//      public String apply(String t) {
//        // TODO Auto-generated method stub
//        return null;
//      }
//    });
    
    
    datas.stream().map(App1::asdf).forEach(System.out::print);  
    
  }
  
  private static void doLocalDate() {
    LocalDateTime ldt = LocalDateTime.of(0, 1, 1, 0, 0, 0, 0);
    System.out.println(ldt.toString());
    String df = ldt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSSS"));
    System.out.println(df);
    
  }
  
  private static boolean filt(String e) {
    if (e.compareTo("3") > 0) {
      return true;
    }
    return false;
  }


  public static String asdf(String as) {
    return null;
  }

}


