package com.ll.client;

import com.ll.disruptor.MessageProducer;
import com.ll.disruptor.RingBufferWorkerPoolFactory;
import com.ll.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        try {
//            TranslatorData responseData = (TranslatorData) msg;
//            System.out.println("Client端:id = " + responseData.getId()
//                    + "Name:" + responseData.getName()
//                    + "Msg:" + responseData.getMessage());
//        } finally {
//            //用完缓存,进行释放
//            ReferenceCountUtil.release(msg);
//        }

        TranslatorData responseData = (TranslatorData) msg;
        String ConsumerClientId = "ClientForNetty:001";
        MessageProducer messageProducer = RingBufferWorkerPoolFactory.getInstance().getMessageProducer(ConsumerClientId);
        messageProducer.onData(responseData, ctx);
    }
}
