package com.doziem.Payment.service;

import com.doziem.Payment.mapper.PaymentMapper;
import com.doziem.Payment.notification.NotificationProducer;
import com.doziem.Payment.notification.PaymentNotificationRequest;
import com.doziem.Payment.payment.PaymentRequest;
import com.doziem.Payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    @Override
    public String createPayment(PaymentRequest request) {

        paymentRepository.save(mapper.toPayment(request));
            notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
);
        return  "Notification Sent Successfully";
    }
}
