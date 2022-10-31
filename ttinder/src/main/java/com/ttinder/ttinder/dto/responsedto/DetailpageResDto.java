package com.ttinder.ttinder.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DetailpageResDto {

    private String photo;

    private String userName;

    private String gender;

    private int age;

    private String mbti;

    private String location;

    private String introduce;

    private Boolean logging;

}
