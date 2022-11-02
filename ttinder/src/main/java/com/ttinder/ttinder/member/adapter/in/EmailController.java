package com.ttinder.ttinder.member.adapter.in;

import com.ttinder.ttinder.member.application.port.in.EmailReqDto;
import com.ttinder.ttinder.member.application.port.in.EmailResDto;
import com.ttinder.ttinder.member.application.port.in.EmailUseCase;
import com.ttinder.ttinder.shared.adapter.in.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailUseCase emailUseCase;

    @PostMapping("/emailConfirm")
    public ResponseDto<EmailResDto> emailConfirm(@RequestBody EmailReqDto emailReqDto) throws Exception{
        return ResponseDto.success(emailUseCase.sendEmail(emailReqDto));
    }
}
