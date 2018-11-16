package com.wanbo.storm;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

public class ISpout extends BaseRichSpout{
	
	private static final long serialVersionUID = -5343851765059550279L;

	private SpoutOutputCollector collector;
	
	private static LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	@Override
	public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
		
		new Thread(this::doWork).start();
		this.collector = collector;
		
	}

	@Override
	public void nextTuple() {		
		try {
			   String data = queue.take();
			   this.collector.emit(new Values(data), "info-id");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("line"));	
	}
	
	
	/**
	 * 模拟向队列放入字符串
	 */
	private void doWork() {
	   int count = 0;
       while(1 > 0) {
//   		double random = Math.random();
   		try {
   			String data = "info:" + count++;
   			queue.put(data);
   			System.err.println("Putting:" + data);
   			Thread.sleep(2000);
   		} catch (InterruptedException e) {
   			e.printStackTrace();
   		}
       }
	}

}
