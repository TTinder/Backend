package com.ttinder.ttinder.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MessageReqDto {
    private String message;

    public MessageReqDto(String message) {
        this.message = message;
    }
}
