package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.requestdto.EmailReqDto;
import com.ttinder.ttinder.dto.responsedto.EmailResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.service.member.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/emailConfirm")
    public ResponseDto<EmailResDto> emailConfirm(@RequestBody EmailReqDto emailReqDto) throws Exception{
        return ResponseDto.success(emailService.sendSimpleMessage(emailReqDto));
    }
}
