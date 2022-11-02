package com.ttinder.ttinder.member.application.port.in;

public interface EmailUseCase {
    EmailResDto sendEmail(EmailReqDto emailReqDto) throws Exception;
}
