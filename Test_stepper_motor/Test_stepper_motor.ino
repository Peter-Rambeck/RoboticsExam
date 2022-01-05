
const int STEP_PIN = 5;
const int DIR_PIN = 4;

void setup() {
  // put your setup code here, to run once:
  pinMode(STEP_PIN, OUTPUT);
  pinMode(DIR_PIN, OUTPUT);
  pinMode(LED_BUILTIN, OUTPUT);
  digitalWrite(DIR_PIN, HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(STEP_PIN, HIGH);
  digitalWrite(LED_BUILTIN, HIGH);
  delay(10);
  digitalWrite(STEP_PIN, LOW);
  digitalWrite(LED_BUILTIN, LOW);
  delay(50);

}
