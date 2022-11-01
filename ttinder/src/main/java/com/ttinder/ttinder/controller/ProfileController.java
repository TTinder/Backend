package com.ttinder.ttinder.controller;

import com.ttinder.ttinder.dto.responsedto.global.ResponseDto;
import com.ttinder.ttinder.security.user.UserDetailsImpl;
import com.ttinder.ttinder.service.member.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/profile")
    public ResponseDto<?> getProfile(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return profileService.getProfile(userDetails.getAccount());
    }
}