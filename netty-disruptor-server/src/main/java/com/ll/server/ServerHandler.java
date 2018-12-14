package com.ll.server;

import com.ll.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TranslatorData requestData = (TranslatorData) msg;
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
