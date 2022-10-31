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

    //memberinfoid추가


    private String photo;

    private String userName;

    private int age;

    private Boolean logging;

    public static int getAmericanAge(String rrnFront) {
        // 오늘 날짜
        LocalDate today = LocalDate.now();
        System.out.println(today);

        int todayYear = today.getYear();
        int todayMonth = today.getMonthValue();
        int todayDay = today.getDayOfMonth();

        // 주민등록번호를 통해 입력 받은 날짜
        int year = Integer.parseInt(rrnFront.substring(0,4));
        int month = Integer.parseInt(rrnFront.substring(4,6));
        int day = Integer.parseInt(rrnFront.substring(6,8));
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        // 올해 - 태어난년도
        int americanAge = todayYear - year;


        // 생일이 안지났으면 - 1
        if(month > todayMonth) {
            americanAge--;
        } else if(month == todayMonth) {
            if(day > todayDay) {
                americanAge--;
            }
        }

        return americanAge;
    }

    public MainpageResDto(MemberInfo memberInfo) {
        this.photo = memberInfo.getPhoto();
        this.userName = memberInfo.getUserName();
//        this.age = getAmericanAge();
        this.logging = memberInfo.getLogging();
    }
}