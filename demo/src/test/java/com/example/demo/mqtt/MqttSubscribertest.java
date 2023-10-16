// package com.example.demo.mqtt;

// import org.eclipse.paho.client.mqttv3.MqttClient;
// import org.eclipse.paho.client.mqttv3.MqttMessage;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.exceptions.base.MockitoException;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.example.demo.Repository.ProductRepository;


// @ExtendWith(MockitoExtension.class)
// public class MqttSubscribertest {


//     @InjectMocks
//     MqttSubscriberCallback mqttSubscriberImpl;

//     @Mock
//     ProductRepository productrepo;

//     @Mock
//     private MqttClient mqttClient;



//     @Test
//     void testConnectionLost() {
//         mqttSubscriberImpl.connectionLost(new Throwable("error"));      
//     }

//     @Test
//     void testDeliveryComplete() {
        
//     }

//     @Test
//     void testMessageArrived() {
//         String message1 = "{\"op\": \"create\",\"data\":\"data\"}";
//         String message2 = "{\"op\": \"xml\",\"data\":\"data\"}";
//         String message3 = "{\"op\": \"update\",\"data\":\"data\",\"id\":\"id\"}";
//         String message4 = "{\"op\": \"delete\",\"id\":\"id\"}";
//         String message5 = "{\"op\": \"deleteAll\"}";

//         try {
//             MqttMessage mqttMessage = new MqttMessage(message1.getBytes());
//             mqttSubscriberImpl.messageArrived("test", mqttMessage);
//             mqttMessage = new MqttMessage(message2.getBytes());
//             mqttSubscriberImpl.messageArrived("test", mqttMessage);
//             mqttMessage = new MqttMessage(message3.getBytes());
//             mqttSubscriberImpl.messageArrived("test", mqttMessage);
//             mqttMessage = new MqttMessage(message4.getBytes());
//             mqttSubscriberImpl.messageArrived("test", mqttMessage);
//             mqttMessage = new MqttMessage(message5.getBytes());
//             mqttSubscriberImpl.messageArrived("test", mqttMessage);


//         } catch (Exception e) {

//         }
//     }
// }
