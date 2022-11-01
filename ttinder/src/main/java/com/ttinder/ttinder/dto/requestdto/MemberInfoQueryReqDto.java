package com.ttinder.ttinder.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MemberInfoQueryReqDto {

    @NotBlank
    private String gender;

    @NotBlank
    private String mbti;

    @NotBlank
    private String location;

//    @NotBlank
//    private int age;
}