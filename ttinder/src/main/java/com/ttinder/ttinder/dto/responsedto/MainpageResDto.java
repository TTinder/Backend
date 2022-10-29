package com.ttinder.ttinder.dto.responsedto;

import com.ttinder.ttinder.entity.Member;
import com.ttinder.ttinder.entity.MemberInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.parsing.Problem;

import static com.ttinder.ttinder.entity.QMemberInfo.memberInfo;

@Getter
@AllArgsConstructor
@Builder

public class MainpageResDto {

    private String photo;

    private String userName;

//    private LocalDate birthDate;

    private Boolean logging;

    public MainpageResDto(MemberInfo memberInfo) {
        this.photo = memberInfo.getPhoto();
        this.userName = memberInfo.getUserName();
//        this.birthDate = memberInfo.getBirthDate();
        this.logging = memberInfo.getLogging();
    }
}