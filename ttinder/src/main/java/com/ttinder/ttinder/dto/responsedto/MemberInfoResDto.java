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

    private String photo;

    private String userName;

    private String gender;

    private int age;

    private String mbti;

    private String location;

    private String introduce;

    private Boolean logging;
<<<<<<< HEAD
=======

>>>>>>> c9202b78cfca5927124f4ca275d324f1a7b24235

}




