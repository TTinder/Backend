package com.ttinder.ttinder.member.adapter.in;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TokenDto {

    private String Authorization;
    private String Refresh_Token;

    public TokenDto(String accessToken, String refreshToken) {
        this.Authorization = accessToken;
        this.Refresh_Token = refreshToken;
    }

}
