package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.service.member.MainpageService;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MainpageController {

    private final MainpageService mainpageService;

    @GetMapping("/mainpage")
<<<<<<< HEAD
    public ResponseDto getAllMember(@PageableDefault(size = 5, sort = "writeTime", direction = Sort.Direction.DESC) Pageable pageable) {
=======
    public ResponseDto getAllMember(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
>>>>>>> 25f872aaeac7e27a556949d91861821aa117dbb6
        return mainpageService.findAllMember(pageable);
    }

}
