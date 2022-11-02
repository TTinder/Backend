package com.ttinder.ttinder.member.adapter.out;


import com.ttinder.ttinder.member.application.port.out.RefreshTokenPort;
import com.ttinder.ttinder.member.domain.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RefreshTokenPersistenceAdapter implements RefreshTokenPort {
    private final RefreshTokenRepository refreshTokenRepository;
    private final RefreshTokenMapper refreshTokenMapper;

    @Override
    public void refreshTokenLogin(String email) {
        Optional<RefreshTokenEntity> refreshTokenEntity = refreshTokenRepository.findByEmail(email);

        if(refreshTokenEntity.isPresent()) {
            RefreshToken refreshToken = refreshTokenMapper.toDomain(refreshTokenEntity);
            refreshTokenRepository.save(refreshToken.updateToken(tokenDto.getRefresh_Token()));
        }else {
            RefreshToken newToken = new RefreshToken(tokenDto.getRefresh_Token(), loginReqDto.getEmail());
            refreshTokenRepository.save(newToken);
        }
    }
}
