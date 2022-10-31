package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.requestdto.MessageReqDto;
import com.ttinder.ttinder.dto.responsedto.MessageResDto;
import com.ttinder.ttinder.dto.responsedto.SuccessResDto;
import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.security.user.UserDetailsImpl;
import com.ttinder.ttinder.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/messages/{id}")
    public ResponseDto<SuccessResDto> sendMessage(@PathVariable Long id,
                                                  @RequestBody MessageReqDto messageReqDto,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseDto.success(messageService.sendMessage(userDetails.getAccount(),messageReqDto,id));
    }

    @GetMapping("/messages")
    public ResponseDto<List<MessageResDto>> myMessage(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseDto.success(messageService.myMessage(userDetails.getAccount()));
    }
}
