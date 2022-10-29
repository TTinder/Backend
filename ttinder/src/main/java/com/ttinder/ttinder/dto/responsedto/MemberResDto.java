package com.ttinder.ttinder.dto.responsedto;

import com.ttinder.ttinder.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberResDto {
    private String email;

    private Boolean info;

    public MemberResDto(Member member, Boolean info) {
        this.info = info;
        this.email = member.getEmail();
    }
}
