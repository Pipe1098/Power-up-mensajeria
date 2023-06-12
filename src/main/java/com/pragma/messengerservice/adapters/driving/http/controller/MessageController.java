package com.pragma.messengerservice.adapters.driving.http.controller;

import com.pragma.messengerservice.adapters.driving.http.dto.request.SmsMessageRequestDto;
import com.pragma.messengerservice.adapters.driving.http.handler.impl.IMessageHandler;
import com.pragma.messengerservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/sms")
@RequiredArgsConstructor
public class MessageController {

    private final IMessageHandler handlerMesagge;

    @Operation(summary = "Send a new sms message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sms message created and sent ", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error sending sms message", content = @Content)
    })
    @PostMapping("")
    public ResponseEntity<Map<String,String>> sendSmsMessage(@Valid @RequestBody SmsMessageRequestDto smsMessageRequestDto) {
        handlerMesagge.sendSmsMessage(smsMessageRequestDto);
       return ResponseEntity.status(HttpStatus.OK).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.MESSAGE_SEND));
    }

}
