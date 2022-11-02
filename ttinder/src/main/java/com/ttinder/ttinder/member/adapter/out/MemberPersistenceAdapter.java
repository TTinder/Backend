package com.ttinder.ttinder.member.adapter.out;

import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.member.application.port.in.MemberReqDto;
import com.ttinder.ttinder.member.application.port.out.FindEmailPort;
import com.ttinder.ttinder.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements FindEmailPort {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;


    @Override
    public void findEmail(String email) {
        if(memberRepository.findByEmail(email).isPresent()){
            throw new RequestException(ErrorCode.USERID_DUPLICATION_409);
        }
    }

    @Override
    public void saveMember(Member member) {
        MemberEntity memberEntity = memberMapper.toEntity(member);
        memberRepository.save(memberEntity);
    }
}
