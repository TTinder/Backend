package com.ttinder.ttinder.dto.requestdto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class MemberReqDto {

    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public void setEncodePwd(String encodePwd) {
        this.password = encodePwd;
    }


}
