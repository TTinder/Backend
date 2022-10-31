package com.ttinder.ttinder.service.member;


import com.ttinder.ttinder.dto.requestdto.LoginReqDto;
import com.ttinder.ttinder.dto.responsedto.MemberResDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.entity.RefreshToken;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.dto.responsedto.TokenDto;
import com.ttinder.ttinder.jwt.util.JwtUtil;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import com.ttinder.ttinder.repository.MemberRepository;
import com.ttinder.ttinder.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final RefreshTokenRepository refreshTokenRepository;

     private final MemberInfoRepository memberInfoRepository;


    @Transactional
    public MemberResDto login(@Valid LoginReqDto loginReqDto, HttpServletResponse response) {

        // Email로 해당 Member 찾기
        Member member = findMember(loginReqDto);
        // password 일치여부 확인
        passwordCheck(loginReqDto, member);

        TokenDto tokenDto = jwtUtil.createAllToken(loginReqDto.getEmail());

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByEmail(loginReqDto.getEmail());

        if(refreshToken.isPresent()) {
            refreshTokenRepository.save(refreshToken.get().updateToken(tokenDto.getRefresh_Token()));
        }else {
            RefreshToken newToken = new RefreshToken(tokenDto.getRefresh_Token(), loginReqDto.getEmail());
            refreshTokenRepository.save(newToken);
        }

        setHeader(response, tokenDto);

        if(memberInfoRepository.findByMember(member).isPresent()){
            MemberInfo memberInfo = memberInfoRepository.findByMember(member).orElse(null);
            memberInfo.updateLogging(true);
            return new MemberResDto(member,true);
        }
        return new MemberResDto(member,false);
    }

    @Transactional
    public SuccessResDto logout(Member member){
         MemberInfo memberInfo = memberInfoRepository.findByMember(member).orElse(null);
         memberInfo.updateLogging(false); // logging
        return new SuccessResDto(true); // 해당 멤버 info logging을 false로 변경
    }


    public String issueToken(HttpServletRequest request, HttpServletResponse response){
        String refreshToken = jwtUtil.getHeaderToken(request, "Refresh");
        if(!jwtUtil.refreshTokenValidation(refreshToken)){
            throw new RequestException(ErrorCode.JWT_EXPIRED_TOKEN_401);
        }

        response.addHeader(JwtUtil.ACCESS_TOKEN, jwtUtil.createToken(jwtUtil.getEmail(refreshToken), "Access"));
        return "Success IssuedToken";
    }

    private void passwordCheck(LoginReqDto loginReqDto, Member member) {
        if(!passwordEncoder.matches(loginReqDto.getPassword(), member.getPassword())) {
            throw new RequestException(ErrorCode.USER_NOT_FOUND_404);
        }
    }

    private Member findMember(LoginReqDto loginReqDto) {
        return memberRepository.findByEmail(loginReqDto.getEmail()).orElseThrow(
                () -> new RequestException(ErrorCode.USER_NOT_FOUND_404)
        );
    }

    private void setHeader(HttpServletResponse response, TokenDto tokenDto) {
        response.addHeader(JwtUtil.ACCESS_TOKEN, tokenDto.getAuthorization());
        response.addHeader(JwtUtil.REFRESH_TOKEN, tokenDto.getRefresh_Token());
    }
}
