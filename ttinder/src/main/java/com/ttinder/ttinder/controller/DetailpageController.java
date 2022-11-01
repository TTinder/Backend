package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.responsedto.DetailpageResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.service.member.DetailpageService;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DetailpageController {

    private final DetailpageService detailpageService;

    //
    @GetMapping("details/{memberInfoId}")
    public ResponseDto<DetailpageResDto> getDetailsInfo(@PathVariable("memberInfoId") Long id){
        return ResponseDto.success(detailpageService.getDetailsInfo(id));
    }
}
