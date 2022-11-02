package com.ttinder.ttinder.member.application.port.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginReqDto {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}

