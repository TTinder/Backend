package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.security.user.UserDetailsImpl;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberInfoController {

    private final MemberInfoService memberInfoService;

    @PostMapping("/info")
    public ResponseDto<?> saveInfo(@RequestPart(required = false,value = "file") List<MultipartFile> multipartFile,
                                   @RequestPart(value = "memberInfoReqDto") MemberInfoReqDto memberInfoReqDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) throws IOException {
        return memberInfoService.saveInfo(multipartFile, memberInfoReqDto, userDetailsImpl.getAccount());
    }
}
