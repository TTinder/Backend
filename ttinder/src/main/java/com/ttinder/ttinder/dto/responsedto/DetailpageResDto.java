package com.ttinder.ttinder.dto.responsedto;

import com.ttinder.ttinder.entity.MemberInfo;
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


    public static DetailpageResDto detailpageResDto(MemberInfo memberInfo) {
        return DetailpageResDto.builder()
                .logging(memberInfo.getLogging())
                .photo(memberInfo.getPhoto())
                .userName(memberInfo.getUserName())
                .gender(memberInfo.getGender())
                .age(memberInfo.getAmericanAge(memberInfo.getBirthDate()))
                .mbti(memberInfo.getMbti())
                .location(memberInfo.getLocation())
                .introduce(memberInfo.getIntroduce())
                .build();
    }


}
