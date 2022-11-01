package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.responsedto.MainpageResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.entity.MemberInfo;
import com.ttinder.ttinder.service.member.MainpageService;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainpageController {

    private final MainpageService mainpageService;

    @GetMapping("/mainpage")
    public ResponseDto<List<MainpageResDto>> getAllMember(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseDto.success(mainpageService.findAllMember(pageable));
    }

    @GetMapping("/mainpage/filter")
    public List<MemberInfo> findByGender(@PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                         @RequestParam(value = "gender", required = false, defaultValue = "ALL") List<String> gender,
                                         @RequestParam(value = "location", required = false, defaultValue = "ALL") List<String> location,
                                         @RequestParam(value = "mbti", required = false, defaultValue = "ALL") List<String> mbti,
                                         @RequestParam(value = "age", required = false, defaultValue = "ALL") List<Integer> age){

        return ResponseDto.success(mainpageService.filter(pageable,gender,age,mbti,location));
    }
}
