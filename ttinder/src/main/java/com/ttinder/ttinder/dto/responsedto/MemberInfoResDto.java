package com.ttinder.ttinder.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberInfoResDto {

    private boolean info;

    private String photo;

    private String email;

    private String userName;

    private String gender;

    private LocalDate birthDate;

    private String mbti;

    private String location;

    private String introduce;

}
