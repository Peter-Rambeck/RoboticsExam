package org.abstractica.openbuildsystem.Nema17Controller;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


    public class Mqqt_Publisher {


        public static void mqqtNemaPublisher(String direction,int position, int speed) {
            String topic = "insession";
            int qos = 2;
            String broker = "tcp://broker.emqx.io:1883";
            String clientId = "java_publisher";
            MemoryPersistence persistence = new MemoryPersistence();
            String content=direction;
            //add position
            content=content+(char)(position/256)+(char)(position%256);
             //add speed
            content=content + (char)(speed/256)+(char)(speed%256);

            try {
                MqttClient client = new MqttClient(broker, clientId, persistence);

                // MQTT connection option
                MqttConnectOptions connOpts = new MqttConnectOptions();
                connOpts.setUserName("emqx_test");
                connOpts.setPassword("emqx_test_password".toCharArray());
                // retain session
                connOpts.setCleanSession(true);
                // set callback
                client.setCallback(new PushCallback());
                // establish a connection
                System.out.println("Connecting to broker: " + broker);
                client.connect(connOpts);
                System.out.println("Connected");
                System.out.println("Publishing message: " + content);
                // Required parameters for message publishing
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                client.publish(topic, message);
                System.out.println("Message published");

                client.disconnect();
                System.out.println("Disconnected");
                client.close();

            } catch (MqttException me) {
                System.out.println("reason " + me.getReasonCode());
                System.out.println("msg " + me.getMessage());
                System.out.println("loc " + me.getLocalizedMessage());
                System.out.println("cause " + me.getCause());
                System.out.println("excep " + me);
                me.printStackTrace();
            }
        }
    }

