// package com.example.demo.mqtt;

// import org.eclipse.paho.client.mqttv3.MqttClient;
// import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
// import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class Mqttconfiguration {

//    @Autowired 
//    MqttSubscriberCallback subscriber;

    
//     private final String MQTT_BROKER_URL = "tcp://mqtt:1883"; // Replace with your MQTT broker's IP and port
//     private final String CLIENT_ID = "spring_boot_backend"; // Choose any unique client ID

//     @Bean
//     public MqttClient mqttClient() throws Exception {
//         MemoryPersistence persistence = new MemoryPersistence();
//         MqttClient mqttClient = new MqttClient(MQTT_BROKER_URL, CLIENT_ID,persistence);
//         MqttConnectOptions connOpts = new MqttConnectOptions();
//         connOpts.setCleanSession(true);

//         mqttClient.setCallback(subscriber); // Create this class to handle received messages
//         mqttClient.connect(connOpts);
//         mqttClient.subscribe("data/write");
//         System.out.println("sigho");

//         return mqttClient;
//     }
// }