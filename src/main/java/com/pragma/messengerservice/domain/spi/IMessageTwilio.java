package com.pragma.messengerservice.domain.spi;


import com.pragma.messengerservice.domain.model.MessageModel;

public interface IMessageTwilio {

    void sendSmsMessage(MessageModel messageModel);
}
