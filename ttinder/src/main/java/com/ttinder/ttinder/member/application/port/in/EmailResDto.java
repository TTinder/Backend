package com.ttinder.ttinder.member.application.port.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EmailResDto {
    private String code;

    public EmailResDto(String code) {
        this.code = code;
    }
}
