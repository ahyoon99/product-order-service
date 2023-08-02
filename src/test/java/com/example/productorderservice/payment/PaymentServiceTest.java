package com.example.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private final PaymentSteps paymentSteps = new PaymentSteps();
    private PaymentService paymentService;
    private PaymentPort paymentPort;

    @BeforeEach
    void setUp() {
        final PaymentGateway paymentGateway = new ConsolePaymentGateway();
        final PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    void 상품주문() {
        final PaymentRequest request = paymentSteps.주문결제요청_생성();

        paymentService.payment(request);
    }

    public PaymentRequest 주문결제요청_생성() {
        return paymentSteps.주문결제요청_생성();
    }

}
