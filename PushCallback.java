package org.abstractica.openbuildsystem.Nema17Controller;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PushCallback implements MqttCallback{
    @Override
    public void connectionLost(Throwable throwable) {
        // After the connection is lost, it usually reconnects here
        System.out.println("disconnect，you can reconnect");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // The messages obtained after subscribe will be executed here
        System.out.println("Received message topic:" + topic);
        System.out.println("Received message Qos:" + message.getQos());
        System.out.println("Received message content:" + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}