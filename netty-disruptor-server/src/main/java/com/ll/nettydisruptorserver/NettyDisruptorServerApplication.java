package com.ll.nettydisruptorserver;

import com.ll.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NettyDisruptorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NettyDisruptorServerApplication.class, args);
        new NettyServer();
    }
}
