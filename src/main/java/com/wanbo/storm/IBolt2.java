package com.wanbo.storm;

import java.util.Map;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.MessageId;
import backtype.storm.tuple.Tuple;

public class IBolt2 extends BaseBasicBolt{
  

  
  private String name;

  private int id;
  
  @Override
  public void prepare(Map stormConf, TopologyContext context) {
      this.name = context.getThisComponentId();
      this.id = context.getThisTaskId();
  }

  @Override
  public void execute(Tuple input, BasicOutputCollector collector) {
      // TODO Auto-generated method stub
      String data = input.getString(0);
      MessageId msgId = input.getMessageId();
      System.err.println("Bolt2" + ":" + data);
  }

  @Override
  public void declareOutputFields(OutputFieldsDeclarer declarer) {
      declarer.declare(new Fields("line"));

  }



}
