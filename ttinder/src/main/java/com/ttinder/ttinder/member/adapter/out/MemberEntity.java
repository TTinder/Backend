package com.ttinder.ttinder.member.adapter.out;

import com.ttinder.ttinder.dto.requestdto.MemberReqDto;
import com.ttinder.ttinder.member.domain.Member;
import com.ttinder.ttinder.shared.adapter.out.TimeStamped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}

