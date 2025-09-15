package com.doziem.Payment.service;

import com.doziem.Payment.payment.PaymentRequest;

public interface PaymentService {
    String  createPayment(PaymentRequest request);
}
