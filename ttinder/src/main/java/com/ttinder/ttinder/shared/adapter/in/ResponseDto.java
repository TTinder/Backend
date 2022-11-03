package com.ttinder.ttinder.shared.adapter.in;

import com.ttinder.ttinder.shared.domain.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private T data;
    private Error error;

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(true, data, null);
    }

    public static <T> ResponseDto<T> fails(HttpStatus httpStatus, String message) {
        return new ResponseDto<>(false, null, new Error(httpStatus,message));
    }
}
