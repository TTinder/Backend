package com.ttinder.ttinder.member.application.service;

import com.ttinder.ttinder.member.application.port.in.MemberReqDto;
import com.ttinder.ttinder.member.application.port.in.SignupUseCase;
import com.ttinder.ttinder.member.application.port.in.SuccessResDto;
import com.ttinder.ttinder.member.application.port.out.FindEmailPort;
import com.ttinder.ttinder.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService implements SignupUseCase {
    private final PasswordEncoder passwordEncoder;
    private final FindEmailPort findEmailPort;

    @Transactional
    @Override
    public SuccessResDto signup(MemberReqDto memberReqDto) {
        findEmailPort.findEmail(memberReqDto.getEmail());

        memberReqDto.setEncodePwd(passwordEncoder.encode(memberReqDto.getPassword()));

        Member member = Member.builder()
                .email(memberReqDto.getEmail())
                .password(memberReqDto.getPassword())
                .build();

        findEmailPort.saveMember(member);
        return new SuccessResDto(true);
    }
}
