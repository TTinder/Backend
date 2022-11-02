package com.ttinder.ttinder.member.application.service;

import com.ttinder.ttinder.member.adapter.in.LoginReqDto;
import com.ttinder.ttinder.member.adapter.in.LoginUseCase;
import com.ttinder.ttinder.member.adapter.in.TokenDto;
import com.ttinder.ttinder.member.application.port.in.MemberResDto;
import com.ttinder.ttinder.member.application.port.out.FindMemberPort;
import com.ttinder.ttinder.shared.domain.ErrorCode;
import com.ttinder.ttinder.shared.domain.RequestException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.Date;

import static com.ttinder.ttinder.jwt.util.JwtUtil.BEARER_TYPE;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    private final FindMemberPort findMemberPort;
    private final PasswordEncoder passwordEncoder;

    private static final long ACCESS_TIME = 100000 * 1000L;
    private static final long REFRESH_TIME = 6000000 * 1000L;

    @Value("${jwt.secret.key}")
    private String secretKey;
    private Key key;
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Override
    public MemberResDto login(LoginReqDto loginReqDto, HttpServletResponse response) {

        // Email로 해당 Member 찾고 비밀번호 리턴
        String pw = findMemberPort.findMember(loginReqDto.getEmail());
        // password 일치여부 확인
        passwordCheck(loginReqDto.getPassword(), pw);

        TokenDto tokenDto = createAllToken(loginReqDto.getEmail());

    }
    private void passwordCheck(String loginPw, String memberPw) {
        if(!passwordEncoder.matches(loginPw, memberPw)) {
            throw new RequestException(ErrorCode.USER_NOT_FOUND_404);
        }
    }
    public TokenDto createAllToken(String email) {
        return new TokenDto(createToken(email, "Access"), createToken(email, "Refresh"));
    }

    public String createToken(String email, String type) {

        Date date = new Date();

        long time = type.equals("Access") ? ACCESS_TIME : REFRESH_TIME;

        return BEARER_TYPE+ Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(date.getTime() + time))
                .setIssuedAt(date)
                .signWith(key, signatureAlgorithm)
                .compact();

    }
}
