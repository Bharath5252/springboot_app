// package com.example.demo.mqtt;

// import java.util.Map;

// import org.eclipse.paho.client.mqttv3.MqttCallback;
// import org.eclipse.paho.client.mqttv3.MqttMessage;
// import org.json.simple.JSONObject;
// import org.json.simple.JSONValue;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;


// import com.example.demo.Model.product;
// import com.example.demo.Repository.ProductRepository;


// @Component(value="subscriber")
// public class MqttSubscriberCallback implements MqttCallback {


//   @Autowired
//   ProductRepository productrepo;


//     @Override
//     public void connectionLost(Throwable cause) {
//         System.out.println(cause);
//         System.out.println("Connection to MQTT broker lost!");
//     }

//     @Override
//     public void messageArrived(String topic, MqttMessage message) throws Exception {
//         System.out.println("Received message from topic: " + topic);
//         System.out.println("Message: " + new String(message.getPayload()));

//         String  temp= new String(message.getPayload());

//         Object obj=JSONValue.parse(temp);  
//         JSONObject jsonObject = (JSONObject) obj; 
        
       

       

//         product temp1= new product();

//         temp1.name=(String) jsonObject.get("name");
//         temp1.price=(String) jsonObject.get("price");
//         temp1.description=(String) jsonObject.get("description");


//         System.out.print(temp1.name);
//         System.out.print(temp1.price);


       
//         productrepo.save(temp1);
//         System.out.println("Done Succesfully");
    
        

       

        

//         // Implement your logic to handle the received message here
//     }

//     @Override
//     public void deliveryComplete(org.eclipse.paho.client.mqttv3.IMqttDeliveryToken token) {
//         // Not used in subscriber
//     }
// }