package com.doziem.Order.handler;

import java.util.Map;

public record ErrorResponse(Map<String, String> error) {
}
