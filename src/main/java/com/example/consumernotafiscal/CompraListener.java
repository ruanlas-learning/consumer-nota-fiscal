package com.example.consumernotafiscal;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

//@EnableBinding(Sink.class)
@EnableBinding(CompraBinding.class)
public class CompraListener {

//    @StreamListener(Sink.INPUT)
//    public void listen(CompraInput input){
//    public void listen(Message<CompraInput> message){
    @StreamListener(CompraBinding.INPUT_NOVA_COMPRA)
    public void listenNova(Message<CompraInput> message){
        Acknowledgment ack = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        String key = message.getHeaders().get(KafkaHeaders.RECEIVED_MESSAGE_KEY, String.class);
        CompraInput compraInput = message.getPayload();

        System.out.println("Key: " + key);
        System.out.println(compraInput);

        if (ack != null){
            System.out.println("Acknowledgment provided");
            ack.acknowledge();
        }
    }

    @StreamListener(CompraBinding.INPUT_CANCELAMENTO)
    public void listenCancela(Message<CancelaCompraInput> message){
        Acknowledgment ack = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);

        String key = message.getHeaders().get(KafkaHeaders.RECEIVED_MESSAGE_KEY, String.class);
        CancelaCompraInput compraInput = message.getPayload();

        System.out.println("Key: " + key);
        System.out.println(compraInput);

        if (ack != null){
            System.out.println("Acknowledgment provided");
            ack.acknowledge();
        }
    }
}
