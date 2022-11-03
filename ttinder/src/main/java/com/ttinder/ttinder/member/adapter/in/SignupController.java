package com.ttinder.ttinder.member.adapter.in;

import com.ttinder.ttinder.member.application.port.in.MemberReqDto;
import com.ttinder.ttinder.member.application.port.in.SignupUseCase;
import com.ttinder.ttinder.member.application.port.in.SuccessResDto;
import com.ttinder.ttinder.shared.adapter.in.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SignupController {

    private SignupUseCase signupUseCase;

    @PostMapping("/signup")
    public ResponseDto<SuccessResDto> signup(@RequestBody @Valid MemberReqDto memberReqDto) {
        return ResponseDto.success(signupUseCase.signup(memberReqDto));
    }

}
