package com.ttinder.ttinder.dto.responsedto;

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
