package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.responsedto.DetailpageResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DetailpageService {

    private final MemberInfoRepository memberInfoRepository;

    private MemberInfo getMemberInfo(Long memberInfoId) {
        MemberInfo memberInfo = memberInfoRepository.findById(memberInfoId).orElseThrow();
//예외처리 필요
        return memberInfo;
    }

    public ResponseDto<?> getDetailsInfo(Long memberInfoId){
        MemberInfo memberInfo = getMemberInfo(memberInfoId);
        return ResponseDto.success(
                DetailpageResDto.builder()
                        .logging(memberInfo.getLogging())
                        .photo(memberInfo.getPhoto())
                        .userName(memberInfo.getUserName())
                        .gender(memberInfo.getGender())
//                        .age(memberInfo.getAge())
                        .mbti(memberInfo.getMbti())
                        .location(memberInfo.getLocation())
                        .introduce(memberInfo.getIntroduce())
                        .build()
        );
    }
}
