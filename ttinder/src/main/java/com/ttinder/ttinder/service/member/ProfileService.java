package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.responsedto.ProfileResDto;
import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileService {

    private final MemberInfoRepository memberInfoRepository;


    public ProfileResDto getProfile(Member member) {
        MemberInfo memberInfo = memberInfoRepository.findByMember(member).orElse(null);
        return ProfileResDto.builder()
                        .photo(memberInfo.getPhoto())
                        .userName(memberInfo.getUserName())
                        .build();
    }
}