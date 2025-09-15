package com.doziem.Payment.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
