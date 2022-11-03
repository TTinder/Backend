package com.ttinder.ttinder.member.adapter.out;

import com.ttinder.ttinder.member.domain.RefreshToken;

import java.util.Optional;

public class RefreshTokenMapper {
    public RefreshToken toDomain(RefreshTokenEntity entity){
        return RefreshToken.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .refreshToken(entity.getRefreshToken())
                .build();
    }

    public RefreshTokenEntity toEntity(RefreshToken refreshToken){
        return RefreshTokenEntity.builder()
                .email(refreshToken.getEmail())
                .refreshToken(refreshToken.getRefreshToken())
                .build();
    }
}
