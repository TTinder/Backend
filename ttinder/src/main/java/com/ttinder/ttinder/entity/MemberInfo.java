package com.ttinder.ttinder.entity;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
public class MemberInfo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String photo;

    @NotBlank
    private String fileName;

    @NotBlank
    private String userName;

    @NotBlank
    private String gender;

    @NotBlank
    private LocalDate birthDate;

    @NotBlank
    private String mbti;

    @NotBlank
    private String location;

    @NotBlank
    private String introduce;

    @NotBlank
    private int logging;

    @OneToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @NotBlank
    private boolean info;

    public MemberInfo(MemberInfoReqDto memberInfoReqDto, Member member) {
        this.photo = memberInfoReqDto.getPhoto();
        this.userName = memberInfoReqDto.getUserName();
        this.gender = memberInfoReqDto.getGender();
        this.birthDate = memberInfoReqDto.getBirthDate();
        this.mbti = memberInfoReqDto.getMbti();
        this.location = memberInfoReqDto.getLocation();
        this.introduce = memberInfoReqDto.getIntroduce();
        this.logging = memberInfoReqDto.getLogging();
        this.member = member;
    }
}