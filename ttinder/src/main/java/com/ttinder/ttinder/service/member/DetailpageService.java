package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.responsedto.DetailpageResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.exception.ErrorCode;
import com.ttinder.ttinder.exception.RequestException;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DetailpageService {

    private final MemberInfoRepository memberInfoRepository;

    public DetailpageResDto getDetailsInfo(Long memberInfoId){
        MemberInfo memberInfo = getMemberInfo(memberInfoId);
        return DetailpageResDto.detailpageResDto(memberInfo);
    }

    private MemberInfo getMemberInfo(Long memberInfoId) {
        return memberInfoRepository.findById(memberInfoId).orElseThrow(
                ()-> new RequestException(ErrorCode.USER_NOT_FOUND_404)
        );
    }
}
