package com.wanbo.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class App1 {

	public static void main(String[] args) {
		System.out.println("Begin");
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("I-Spout",new ISpout());
		builder.setBolt("I-Bolt", new IBolt()).shuffleGrouping("I-Spout");
		builder.setBolt("I-Bolt2", new IBolt2()).shuffleGrouping("I-Spout");
		
        //Configuration
		Config conf = new Config();
//		conf.put("wordsFile", file);
		conf.setDebug(false);
        //Topology run
//		conf.put(Config.TOPOLOGY_MAX_SPOUT_PENDING, 1);  
		conf.put(Config.TOPOLOGY_MAX_TASK_PARALLELISM, 1);   // TOPOLOGY_MAX_TASK_PARALLELISM
		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("Getting-Started-Toplogie", conf, builder.createTopology());
//		Thread.sleep(1000);
//		cluster.shutdown();

	}

}
