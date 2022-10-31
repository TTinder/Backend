package com.ttinder.ttinder.dto.responsedto;

import com.ttinder.ttinder.entity.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder

public class MainpageResDto {

    private Long id;

    private String photo;

    private String userName;

    private int age;

    private Boolean logging;

    public MainpageResDto(MemberInfo memberInfo) {
        this.id = memberInfo.getId();
        this.photo = memberInfo.getPhoto();
        this.userName = memberInfo.getUserName();
        this.age = memberInfo.getAmericanAge(memberInfo.getBirthDate());
        this.logging = memberInfo.getLogging();
    }
}