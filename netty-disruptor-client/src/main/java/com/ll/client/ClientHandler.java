package com.ll.client;

import com.ll.entity.TranslatorData;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            TranslatorData responseData = (TranslatorData) msg;
            System.out.println("Client端:id = " + responseData.getId()
                    + "Name:" + responseData.getName()
                    + "Msg:" + responseData.getMessage());
        } finally {
            //用完缓存,进行释放
            ReferenceCountUtil.release(msg);
        }
    }
}
