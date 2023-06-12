package com.pragma.messengerservice.adapters.driving.http.mapper;


import com.pragma.messengerservice.adapters.driving.http.dto.request.SmsMessageRequestDto;
import com.pragma.messengerservice.domain.model.MessageModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMessageRequestMapper {

    MessageModel toSmsMessageModel(SmsMessageRequestDto smsMessageRequestDto);
}
