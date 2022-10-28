package com.ttinder.ttinder.entity;

import com.ttinder.ttinder.dto.requestdto.MemberReqDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@NoArgsConstructor
public class Member extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public Member(MemberReqDto memberReqDto) {
        this.email = memberReqDto.getEmail();
        this.password = memberReqDto.getPassword();
    }

}
