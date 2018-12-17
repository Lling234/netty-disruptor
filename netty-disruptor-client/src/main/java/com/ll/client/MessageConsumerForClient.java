package com.ll.client;

import com.ll.disruptor.MessageConsumer;
import com.ll.entity.TranslatorData;
import com.ll.entity.TranslatorDataWapper;
import io.netty.util.ReferenceCountUtil;

public class MessageConsumerForClient extends MessageConsumer {
    public MessageConsumerForClient(String consumerId) {
        super(consumerId);
    }

    @Override
    public void onEvent(TranslatorDataWapper event) throws Exception {
        TranslatorData responseData = event.getData();
        try {

            System.out.println("Client端:id = " + responseData.getId()
                    + "Name:" + responseData.getName()
                    + "Msg:" + responseData.getMessage());
        } finally {
            //用完缓存,进行释放
            ReferenceCountUtil.release(responseData);
        }
    }
}
