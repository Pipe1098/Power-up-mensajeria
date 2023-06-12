package com.pragma.messengerservice.configuration;

import com.pragma.messengerservice.adapters.driven.mysql.adapter.MessageTwilioAdapter;
import com.pragma.messengerservice.domain.api.IMessageServicePort;
import com.pragma.messengerservice.domain.spi.IMessageTwilio;
import com.pragma.messengerservice.domain.usecase.MessageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IMessageTwilio MessageTwilio(){
        return new MessageTwilioAdapter();
    }

    @Bean
    public IMessageServicePort messageServicePort() {
        return new MessageUseCase(MessageTwilio());
    }

}
