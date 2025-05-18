package com.manager.books.exception;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalTime;

@Getter
@Builder
public class ErrorDetail {
    private String message;
    private LocalTime time;
}
