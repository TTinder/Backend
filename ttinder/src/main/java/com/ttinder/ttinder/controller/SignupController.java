package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.requestdto.MemberReqDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.service.member.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SignupController {
    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseDto<SuccessResDto> signup(@RequestBody @Valid MemberReqDto memberReqDto) {
        return ResponseDto.success(signupService.signup(memberReqDto));
    }

}
