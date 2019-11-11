package com.example.consumernotafiscal;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CompraBinding {
    String INPUT_NOVA_COMPRA = "input-nova";
    String INPUT_CANCELAMENTO = "input-cancela";

    @Input(INPUT_CANCELAMENTO)
    SubscribableChannel inputCancelamento();

    @Input(INPUT_NOVA_COMPRA)
    SubscribableChannel inputNova();
}
