package com.ttinder.ttinder.member.adapter.in;


import com.ttinder.ttinder.member.application.port.in.MemberResDto;

import javax.servlet.http.HttpServletResponse;

public interface LoginUseCase {
    MemberResDto login(LoginReqDto loginReqDto, HttpServletResponse response);
}
