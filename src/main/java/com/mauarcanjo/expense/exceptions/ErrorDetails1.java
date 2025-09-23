package com.mauarcanjo.expense.exceptions;

import java.time.LocalDateTime;

public record ErrorDetails1(
        LocalDateTime timestamp,
        String message,
        String details,
        String errorCode
) {
}
