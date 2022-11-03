package com.ttinder.ttinder.member.adapter.out;

import com.ttinder.ttinder.member.domain.Member;

public class MemberMapper {
    public Member toDomain(MemberEntity entity){
        return Member.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    public MemberEntity toEntity(Member member){
        return MemberEntity.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .build();
    }
}
