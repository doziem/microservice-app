package com.doziem.Payment.mapper;

import com.doziem.Payment.payment.Payment;
import com.doziem.Payment.payment.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request){
        if (request==null){
            return null;
        }
        return Payment.builder()
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }

}
