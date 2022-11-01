package com.ttinder.ttinder.entity;

import com.ttinder.ttinder.dto.requestdto.MemberInfoReqDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String photo;

    private int messageNum;

//    @NotBlank
//    private String fileName;

    @NotBlank
    private String userName;

    @NotBlank
    private String gender;

    private LocalDate birthDate;

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
        this.mbti = memberInfoReqDto.getMbti();
        this.location = memberInfoReqDto.getLocation();
        this.introduce = memberInfoReqDto.getIntroduce();
        this.member = member;
        this.info = true;
        this.logging = true;
        this.messageNum = 0;
    }
    // 로깅업데이트함수 로그아웃하면 logging -> 0
    public void updateLogging(Boolean logging){
        this.logging = logging;
    }
    // LocalDate -> ing age : 만나이로 변환
    public int getAmericanAge(LocalDate birthDate) {
        // 오늘 날짜
        LocalDate today = LocalDate.now();

        int americanAge = today.minusYears(birthDate.getYear()).getYear(); // (1)
        // (2)
        // 생일이 지났는지 여부를 판단하기 위해 (1)을 입력받은 생년월일의 연도에 더한다.
        // 연도가 같아짐으로 생년월일만 판단할 수 있다!
        if (birthDate.plusYears(americanAge).isAfter(today)) {
            americanAge = americanAge -1;
        }
        return americanAge;
    }

    public void plusMessageNum(){
        this.messageNum += 1;
    }

}
