package com.pragma.messengerservice.adapters.driven.mysql.adapter;


import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageTwilio;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;


@RequiredArgsConstructor
public class MessageTwilioAdapter implements IMessageTwilio {

    @Value("${TWILIO_SID}")
    private String sid;
    @Value("${TWILIO_TOKEN}")
    private String token;
    @Value("${TWILIO_PHONE_NUMBER}")
    private String phone;


    @Override
    public void sendSmsMessage(MessageModel messageModel) {
        Twilio.init(sid, token);
         Message.creator(
                new PhoneNumber(messageModel.getPhone()),//num destino
                new PhoneNumber(phone),// num origen
                messageModel.getMessage()).
                        create();
    }
}
