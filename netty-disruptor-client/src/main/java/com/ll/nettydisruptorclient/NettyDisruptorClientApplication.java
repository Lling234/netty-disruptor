package com.ll.nettydisruptorclient;

import com.ll.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyDisruptorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyDisruptorClientApplication.class, args);
        new NettyClient().sendData();
    }
}
