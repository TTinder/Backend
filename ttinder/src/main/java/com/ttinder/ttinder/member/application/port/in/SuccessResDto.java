package com.ttinder.ttinder.member.application.port.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SuccessResDto {
    private Boolean success;

    public SuccessResDto(Boolean success) {
        this.success = success;
    }
}
