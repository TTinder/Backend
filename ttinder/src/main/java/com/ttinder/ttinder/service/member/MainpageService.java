package com.ttinder.ttinder.service.member;

import com.ttinder.ttinder.dto.responsedto.MainpageResDto;
import com.ttinder.ttinder.dto.responsedto.MemberInfoResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MainpageService {

    private final MemberInfoRepository memberInfoRepository;



    public ResponseDto<List<MainpageResDto>> findAllMember(Pageable pageable) {
        Page<MemberInfo> allMember = memberInfoRepository.findAll(pageable);//다른 성별만 조회하기 추가해야함
        List<MainpageResDto> memberLists = new ArrayList<>();
        for (MemberInfo memberInfo : allMember) {
            memberLists.add(new MainpageResDto(memberInfo));
        }
        return ResponseDto.success(memberLists);
    }
}
