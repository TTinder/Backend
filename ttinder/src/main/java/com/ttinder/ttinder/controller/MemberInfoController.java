package com.ttinder.ttinder.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.security.user.UserDetailsImpl;
import com.ttinder.ttinder.service.member.MemberInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberInfoController {

    private final MemberInfoService memberInfoService;

//    @GetMapping("/info/{memberInfoId}")
//    public ResponseDto<?> getDetailPost(@PathVariable("memberInfoId") Long id) {
//        return memberInfoService.getDetailPost(id);
//    }

    @PostMapping("/info")
    public ResponseDto<?> saveInfo(@RequestPart(required = false, value = "file") List<MultipartFile> multipartFile,
                                   @RequestPart(value = "memberInfoReqDto") MemberInfoReqDto memberInfoReqDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) throws IOException {
        return memberInfoService.saveInfo(multipartFile, memberInfoReqDto, userDetailsImpl.getAccount());
    }

    @GetMapping("details/{memberInfoId}")
    public ResponseDto<?> getDetailsInfo(@PathVariable("memberInfoId") Long id){
        return memberInfoService.getDetailsInfo(id);
    }
}
//    @PostMapping("/info")
//    public ResponseDto<?> saveInfo(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
//                                                  @RequestPart(value = "dto") @Valid MemberInfoReqDto memberInfoReqDto, // needed application/json
////                                                            @RequestParam("dto") MemberInfoReqDto memberInfoReqDto,                // not needed application/json
////                                                                            @RequestParam String title,
////                                                                            @RequestParam String content,
////                                                                            @RequestParam Integer lowPrice,
//                                                  @RequestPart(value = "file", required = false) MultipartFile multipartFile) throws JsonProcessingException {
//        log.info("===================");
////        log.info("title = {}", title);
////        log.info("content = {}", content);
////        log.info("lowPrice = {}", lowPrice);
//        log.info("memberInfoReqDto = {}", memberInfoReqDto.getGender());
//        log.info(multipartFile.getContentType());
//        log.info("===================");
//
////        ProductRequestPostDto readDto = new ProductRequestPostDto(title, lowPrice, content);
//
////        ObjectMapper objectMapper = new ObjectMapper().registerModule(new SimpleModule());
////        ProductRequestPostDto readDto = objectMapper.readValue(dto, new TypeReference<>() {});
//       return memberInfoService.saveInfo(userDetailsImpl.getAccount(), memberInfoReqDto, multipartFile);
//
//
////        CommonProductResponseDto responseDto = memberInfoService.saveInfo(userDetails.getMember(), readDto, multipartFile);
////        return new ResponseEntity<>(ResponseDto.success(responseDto), memberController.setHeaders(), HttpStatus.OK);
//    }
//}
