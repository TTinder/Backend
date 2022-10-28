package com.ttinder.ttinder.controller;


import com.ttinder.ttinder.dto.requestdto.LoginReqDto;
import com.ttinder.ttinder.dto.requestdto.MemberReqDto;
import com.ttinder.ttinder.dto.responsedto.MemberResDto;
import com.ttinder.ttinder.global.ResponseDto;
import com.ttinder.ttinder.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/signup")
    public ResponseEntity<ResponseDto<String>> signup(@RequestBody @Valid MemberReqDto memberReqDto) {
        return new ResponseEntity<>(ResponseDto.success(memberService.signup(memberReqDto)),HttpStatus.CREATED);
    }

    @PostMapping("/member/login")
    public ResponseDto<MemberResDto> login(@RequestBody @Valid LoginReqDto loginReqDto, HttpServletResponse response) {
        return ResponseDto.success(memberService.login(loginReqDto, response));
    }

    // 토큰 재발급
    @GetMapping("/issue/token")
    public ResponseDto<String> issuedToken(HttpServletRequest request, HttpServletResponse response){
        return ResponseDto.success(memberService.issueToken(request,response));
    }
}
