package com.wanbo.rocketmq;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import java.util.Properties;

public class AppConsumer {
    public static void main(String[] args) {
        
        Properties properties = new Properties();
        // 您在控制台创建的 Consumer ID
        properties.put(PropertyKeyConst.ConsumerId, "CID-monitor-alp-test");
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, "LTAI3297m9ZJIp2T");
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "rbTce2Lg25GSUNhX2ujw57xPvtKPke");
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put(PropertyKeyConst.ONSAddr, "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
        // 集群订阅方式 (默认)
        // properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.CLUSTERING);
        // 广播订阅方式
        // properties.put(PropertyKeyConst.MessageModel,
        // PropertyValueConst.BROADCASTING);
        Consumer consumer = ONSFactory.createConsumer(properties);
        consumer.subscribe("monitor-alp-test", "monitor", new MessageListener() { // 订阅多个 Tag
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive: " + message);
                System.out.println(new String(message.getBody()));
                return Action.CommitMessage;
            }
        });
        // 订阅另外一个 Topic
        /*
         * consumer.subscribe("TopicTestMQ-Other", "*", new MessageListener() { // 订阅全部
         * Tag public Action consume(Message message, ConsumeContext context) {
         * System.out.println("Receive: " + message); return Action.CommitMessage; } });
         */
        consumer.start();
        System.out.println("Consumer Started");
    }
}
