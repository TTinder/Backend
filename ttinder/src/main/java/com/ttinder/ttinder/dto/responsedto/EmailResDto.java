package com.ttinder.ttinder.dto.responsedto;

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
