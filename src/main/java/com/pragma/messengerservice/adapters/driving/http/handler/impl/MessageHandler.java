package com.pragma.messengerservice.adapters.driving.http.handler.impl;


import com.pragma.messengerservice.adapters.driving.http.dto.request.SmsMessageRequestDto;
import com.pragma.messengerservice.adapters.driving.http.mapper.IMessageRequestMapper;
import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.model.MessageModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;

    private final IMessageRequestMapper messageRequestMapper;


    @Override
    public void sendSmsMessage(SmsMessageRequestDto smsMessageRequestDto) {
        MessageModel messageModel = messageRequestMapper.toSmsMessageModel(smsMessageRequestDto);
        messageServicePort.sendSmsMessage(messageModel);
    }
}
