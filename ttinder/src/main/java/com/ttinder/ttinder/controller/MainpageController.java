package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.service.member.MainpageService;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainpageController {

    private final MainpageService mainpageService;

    @GetMapping("/mainpage")
    public ResponseDto getAllMember() {
        return mainpageService.findAllMember();
    }

}
