package com.ttinder.ttinder.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberInfoResDto {

    private Boolean logging;

    private String photo;

    private String userName;

    private String gender;

//    private Long age;

    private String mbti;

    private String location;

    private String introduce;

//    private List<ImgResponseDto> imgResponseDtoList;

}
