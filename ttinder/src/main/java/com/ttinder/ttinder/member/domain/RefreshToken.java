package com.ttinder.ttinder.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RefreshToken{


    private Long id;

    private String refreshToken;

    private String email;

    public RefreshToken(String token, String email) {
        this.refreshToken = token;
        this.email= email;
    }

    public RefreshToken updateToken(String token) {
        this.refreshToken = token;
        return this;
    }

}