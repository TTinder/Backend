package com.ttinder.ttinder.member.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RefreshTokenRepository extends JpaRepository <RefreshTokenEntity, Long> {
    Optional<RefreshTokenEntity> findByEmail(String email);
}
