package com.ttinder.ttinder.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
/*@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RedisHash(value = "refreshToken", timeToLive = 24*60*60) //24시간
public class RefreshToken{

    @Id
    private String refreshToken;
    private String userId;
}*/

@Getter
@Entity
@NoArgsConstructor
public class RefreshToken extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String refreshToken;
    @NotBlank
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
