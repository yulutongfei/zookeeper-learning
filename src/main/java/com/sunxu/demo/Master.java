package com.sunxu.demo;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class Master implements Watcher {

    private ZooKeeper zk;
    private String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    private void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }
    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Master m = new Master("localhost:2181");
        m.startZK();
        Thread.sleep(60000);
    }
}
