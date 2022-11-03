package com.ttinder.ttinder.member.application.port.out;

import com.ttinder.ttinder.member.application.port.in.MemberReqDto;
import com.ttinder.ttinder.member.domain.Member;

public interface FindEmailPort {
    void findEmail(String email);
    void saveMember(Member member);
}
