package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.repository.MemberInfoQueryRepository;
import com.ttinder.ttinder.security.user.UserDetailsImpl;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberInfoController {

    private final MemberInfoService memberInfoService;

    //정보입력
    @PostMapping("/info")
    public ResponseDto<SuccessResDto> saveInfo(@RequestPart(value = "file", required = false) MultipartFile file,
                                               MemberInfoReqDto memberInfoReqDto,
                                               @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) throws IOException {
        return ResponseDto.success(memberInfoService.saveInfo(file, memberInfoReqDto, userDetailsImpl.getAccount()));
    }
}