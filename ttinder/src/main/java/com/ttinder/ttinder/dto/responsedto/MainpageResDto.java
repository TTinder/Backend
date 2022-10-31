package com.ttinder.ttinder.dto.responsedto;

import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.parsing.Problem;

import java.time.LocalDate;

import static com.ttinder.ttinder.entity.QMemberInfo.memberInfo;

@Getter
@AllArgsConstructor
@Builder

public class MainpageResDto {

    private String photo;

    private String userName;

    private int age;

    private Boolean logging;

    public MainpageResDto(MemberInfo memberInfo) {
        this.photo = memberInfo.getPhoto();
        this.userName = memberInfo.getUserName();
        this.age = memberInfo.getAmericanAge(memberInfo.getBirthDate());
        this.logging = memberInfo.getLogging();
    }
}