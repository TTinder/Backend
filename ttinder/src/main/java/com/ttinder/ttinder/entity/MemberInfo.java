package com.ttinder.ttinder.entity;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Entity
@Setter
@NoArgsConstructor
public class MemberInfo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String photo;

////    @NotBlank
//    private String fileName;

    @NotBlank
    private String userName;

    @NotBlank
    private String gender;

//    private LocalDate birthDate;

    @NotBlank
    private String mbti;

    @NotBlank
    private String location;

    @NotBlank
    private String introduce;

    private Boolean logging;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    private Boolean info;

    public MemberInfo(MemberInfoReqDto memberInfoReqDto, Member member) {
        this.photo = memberInfoReqDto.getPhoto();
        this.userName = memberInfoReqDto.getUserName();
        this.gender = memberInfoReqDto.getGender();
//        this.birthDate = memberInfoReqDto.getBirthDate();
        this.mbti = memberInfoReqDto.getMbti();
        this.location = memberInfoReqDto.getLocation();
        this.introduce = memberInfoReqDto.getIntroduce();
        this.member = member;
        this.info = true;
        this.logging = true;
    }
    // 로깅업데이트함수 로그아웃하면 logging -> 0
    public void updateLogging(Boolean logging){
        this.logging = logging;
    }
}