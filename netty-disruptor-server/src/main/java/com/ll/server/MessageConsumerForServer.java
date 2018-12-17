package com.ll.server;

import com.ll.disruptor.MessageConsumer;
import com.ll.entity.TranslatorData;
import com.ll.entity.TranslatorDataWapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class MessageConsumerForServer extends MessageConsumer {
    public MessageConsumerForServer(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWapper event) throws Exception {
        TranslatorData requestData = event.getData();
        ChannelHandlerContext ctx = event.getCtx();

        System.out.println("服务端数据:"
                + "ID:" + requestData.getId()
                + "NAME:" + requestData.getName()
                + "MSG:" + requestData.getMessage());

        //写出Response响应数据
        TranslatorData responseData = new TranslatorData();
        responseData.setId("resp:" + requestData.getId());
        responseData.setName("resp:" + requestData.getName());
        responseData.setMessage("resp:" + requestData.getMessage());
        ctx.writeAndFlush(responseData);
    }
}
