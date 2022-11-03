package com.ttinder.ttinder.member.application.port.in;

import javax.validation.Valid;

public interface SignupUseCase {
    SuccessResDto signup(@Valid MemberReqDto memberReqDto);
}
