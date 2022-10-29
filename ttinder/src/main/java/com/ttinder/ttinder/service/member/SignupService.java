package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.requestdto.LoginReqDto;
import com.ttinder.ttinder.dto.requestdto.MemberReqDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Transactional
    public SuccessResDto signup(@Valid MemberReqDto memberReqDto) {
        // Email 중복 검사
        if(memberRepository.findByEmail(memberReqDto.getEmail()).isPresent()){
            throw new RequestException(ErrorCode.USERID_DUPLICATION_409);
        }

        memberReqDto.setEncodePwd(passwordEncoder.encode(memberReqDto.getPassword()));
        Member member = new Member(memberReqDto);

        memberRepository.save(member);
        return new SuccessResDto(true);
    }

}
