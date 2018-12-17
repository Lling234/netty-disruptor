package com.ll.nettydisruptorclient;

import com.ll.client.MessageConsumerForClient;
import com.ll.client.NettyClient;
import com.ll.disruptor.MessageConsumer;
import com.ll.disruptor.RingBufferWorkerPoolFactory;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyDisruptorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyDisruptorClientApplication.class, args);

        MessageConsumer[] mc = new MessageConsumer[4];
        for (int i = 0; i < mc.length; i++) {
            mc[i] = new MessageConsumerForClient("consumerClientCode:" + i);
        }
        RingBufferWorkerPoolFactory.getInstance().initAndStart(ProducerType.MULTI,
                1024 * 1024, new BlockingWaitStrategy(), mc);

        new NettyClient().sendData();
    }
}
