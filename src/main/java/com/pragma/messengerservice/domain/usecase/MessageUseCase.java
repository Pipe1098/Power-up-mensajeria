package com.pragma.messengerservice.domain.usecase;


import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.model.MessageModel;
import com.pragma.messengerservice.domain.spi.IMessageTwilio;

public class MessageUseCase implements IMessageServicePort {

    private final IMessageTwilio messageTwilio;

    public MessageUseCase(IMessageTwilio messageTwilio) {
        this.messageTwilio = messageTwilio;
    }

    @Override
    public void sendSmsMessage(MessageModel messageModel) {
        messageTwilio.sendSmsMessage(messageModel);
    }
}
