package com.supermarket.api.exception.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
    private Integer code;
    private String message;
}
