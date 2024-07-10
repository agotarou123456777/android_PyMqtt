
import paho.mqtt.client as mqtt



# コネクションが確立されたときのコールバック
def on_connect(client, userdata, flags, rc):
    topic = 'test'
    message = 'Hello MQTT'
    print(f"Connected with result code {rc}")
    client.publish(topic, message)
    client.disconnect()


def mqtt_test():
    broker = '10.0.2.2'
    port = 1883
    print("Connected with result")
    client = mqtt.Client()
    client.on_connect = on_connect
    client.connect(broker, port, 60)
    client.loop_start()



#適当な関数を作ってみる
def PyHello():
    text="hello python!"
    print(text)
    return text

#適当なクラスを作ってみる
class SampleClass():
    val = 10

    def get_val(self):
        return self.val

    def set_val(self, new_val):
        self.val = new_val
