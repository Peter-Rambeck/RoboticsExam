#include <ESP8266WiFi.h>
#include <PubSubClient.h>
#include <AccelStepper.h>

// WiFi
const char *ssid = "Rambeck";       // Enter your WiFi name
const char *password = "TiaNuller"; // Enter WiFi password

// MQTT Broker
const char *mqtt_broker = "broker.emqx.io";
const char *topic = "insession";
const char *mqtt_username = "emqx";
const char *mqtt_password = "public";
const int mqtt_port = 1883;

WiFiClient espClient;
PubSubClient client(espClient);
AccelStepper stepper = AccelStepper(1, 5, 4);

void setup()
{
    pinMode(LED_BUILTIN, OUTPUT);

    // Set software serial baud to 115200;
    Serial.begin(115200);
    Serial.print("Test begin ");
    // connecting to a WiFi network
    WiFi.begin(ssid, password);
    while (WiFi.status() != WL_CONNECTED)
    {
        delay(500);
        Serial.println("Connecting to WiFi..");
    }
    Serial.println("Connected to the WiFi network");
    //connecting to a mqtt broker
    client.setServer(mqtt_broker, mqtt_port);
    client.setCallback(callback);
    while (!client.connected())
    {
        String client_id = "esp8266-client-";
        client_id += String(WiFi.macAddress());
        Serial.printf("The client %s connects to the public mqtt broker\n", client_id.c_str());
        if (client.connect(client_id.c_str(), mqtt_username, mqtt_password))
        {
            Serial.println("Public emqx mqtt broker connected");
        }
        else
        {
            Serial.print("failed with state ");
            Serial.print(client.state());
            delay(2000);
        }
    }
    // publish and subscribe
    // client.publish(topic, "hello emqx");
    client.subscribe(topic);

    stepper.setAcceleration(100);
}

void callback(char *topic, byte *payload, unsigned int length)
{
    Serial.println("We're in callback");
    Serial.println(payload[5]);
    if (length > 4)
    {
        stepper.setCurrentPosition(0);

        int speed = payload[3] * 256 + payload[4];
        if (speed > 1000)
        {
            speed = 1000;
        };

        stepper.setSpeed(100);

        int position = payload[1] * 256 + payload[2];
        if (position > 4000)
        {
            position = 4000;
        };

        if ((char)payload[0] == '-')
        {
            position = -position;
        }
        stepper.runToNewPosition(position);
    }
}

void loop()
{
    client.loop();
}
