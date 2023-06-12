package com.pragma.messengerservice.adapters.driving.http.handler.impl;


import com.pragma.messengerservice.adapters.driving.http.dto.request.SmsMessageRequestDto;

public interface IMessageHandler {

    void sendSmsMessage(SmsMessageRequestDto smsMessageRequestDto);
}
