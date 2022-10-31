package com.ttinder.ttinder.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter

@NoArgsConstructor
public class MemberInfoReqDto {

    @NotBlank
    private String photo;

    @NotBlank
    private String userName;

    @NotBlank
    private String gender;

    @NotBlank
    private String birthDate;

    @NotBlank
    private String mbti;

    @NotBlank
    private String location;

    @NotBlank
    private String introduce;
}
