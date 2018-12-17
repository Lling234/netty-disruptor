package com.ll.nettydisruptorserver;

import com.ll.disruptor.MessageConsumer;
import com.ll.disruptor.RingBufferWorkerPoolFactory;
import com.ll.server.MessageConsumerForServer;
import com.ll.server.NettyServer;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyDisruptorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyDisruptorServerApplication.class, args);
        MessageConsumer[] mc = new MessageConsumer[4];
        for (int i = 0; i < mc.length; i++) {
            mc[i] = new MessageConsumerForServer("consumerServerCode:" + i);
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI,
                1024 * 1024, new BlockingWaitStrategy(), mc);
        new NettyServer();
    }
}
