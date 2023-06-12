package com.pragma.messengerservice.adapters.driving.http.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter
@Setter
public class SmsMessageRequestDto {

    @NotBlank(message = "the phone is required")
    @Pattern(regexp = "^\\+57\\d{10}$", message = "phone must start with +57 and have 10 numbers")
    private String phone;

    @NotBlank(message = "Message is required")
    private String message;
}
