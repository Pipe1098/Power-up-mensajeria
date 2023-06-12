package com.pragma.messengerservice.adapters.driven.mysql.adapter;


import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageTwilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class MessageTwilioAdapter implements IMessageTwilio {

    private String ACCOUNT_SID;

    private String AUTH_TOKEN;

    private String PHONE_NUMBER;


    @Override
    public void sendSmsMessage(MessageModel messageModel) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(messageModel.getPhone()),
                new PhoneNumber(PHONE_NUMBER),
                messageModel.getMessage()).
                        create();

        System.out.println(message.getSid());
    }
}
