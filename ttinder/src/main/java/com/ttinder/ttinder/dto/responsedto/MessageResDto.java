package com.ttinder.ttinder.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@Getter
public class MessageResDto {
    private Long id;
    private String photo;
    private String username;
    private String message;

    public MessageResDto(Long id, String photo, String username, String message) {
        this.id = id;
        this.photo = photo;
        this.username = username;
        this.message = message;
    }
}
