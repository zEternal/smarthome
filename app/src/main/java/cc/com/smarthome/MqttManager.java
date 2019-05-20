package cc.com.smarthome;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttManager {
    public static final String TAG = MqttManager.class.getSimpleName();

   // private String host;// = "tcp://shiyan.mqtt.iot.bj.baidubce.com:1883";
   // private String userName;// = "shiyan/esp8266";
    //private String passWord;// = "5FyadUaBpe0RKi7rWBiJQLj+YMFGbsW0/pHZ55KlqAM=";
    private String clientId = "";
    public String pay="chushihua";
    private static MqttManager mqttManager = null;
    private MqttClient client;
    private MqttConnectOptions connectOptions;


    public MqttManager(Context context){

        //       clientId = "DeviceId-k2rcy0jl28";
        clientId = MqttClient.generateClientId();//根据当前用户的登录名和系统时间返回随机生成的客户端标识符。

    }

    public MqttManager getInstance(Context context){
        if(mqttManager == null){
            mqttManager = new MqttManager(context);
        }else{
            return mqttManager;
        }
        return null;
    }

    public void connect(String host,String userName,String passWord){
        try{
            //this.host = host;
            //this.userName = userName;
            //this.passWord = passWord;
            //MqttClient()构造函数 创建可用于与MQTT服务器通信的MqttClient。
            //MqttClient(服务器地址+端口，唯一客户端标识，使用内存持久性？)
            client = new MqttClient(host,clientId,new MemoryPersistence());
            //MqttConnectOptions() 保存控制客户端连接到服务器的方式的选项集。
            connectOptions = new MqttConnectOptions();
            connectOptions.setUserName(userName);//设置用于连接的用户名。
            //setPassword(char[] password)设置用于连接的密码。
            //toCharArray() 方法将字符串转换为字符数组。
            connectOptions.setPassword(passWord.toCharArray());
            //setCallback(MqttCallback callback)设置回调侦听器以用于异步发生的事件。
            client.setCallback(mqttCallback);
            client.connect(connectOptions);//使用默认选项连接到MQTT服务器。
        }catch (MqttException e){//MqttException 如果与服务器通信时发生错误，则抛出该异常。
            e.printStackTrace();//在命令行打印异常信息在程序中出错的位置及原因。
        }
    }

    public void subscribe(String topic,int qos){
        if(client != null){
            int[] Qos = {qos};
            String[] topic1 = {topic};
            try {
                client.subscribe(topic1, Qos);//订阅一个主题，其中可能包含使用QoS为1的通配符
                Log.d(TAG,"订阅topic : "+topic);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

    public void publish(String topic,String msg,boolean isRetained,int qos) {
        try {
            if (client!=null) {
                /*MqttMessage() MQTT消息保存应用程序有效负载和指定消息如何传递
                  的选项消息包括表示为byte []的“payload”    */
                MqttMessage message = new MqttMessage();
                message.setQos(qos);//设置此消息的服务质量。
                message.setRetained(isRetained);//消息传递引擎是否应保留发布消息。
                /*将此消息的有效内容设置为指定的字节数组。
                  getBytes() 使用平台的默认字符集将字符串编码为 byte 序列，
                  并将结果存储到一个新的 byte 数组中。*/
                message.setPayload(msg.getBytes());
                client.publish(topic, message);//将消息发布到服务器上的主题。
            }
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private MqttCallback mqttCallback = new MqttCallback(){

        @Override
        public void connectionLost(Throwable throwable) { }

        @Override
        public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) { }

        @Override
        //当消息从服务器到达时，将调用此方法。
        public void messageArrived(String topic, MqttMessage message){
            //getPayload()  将有效内容作为字节数组返回。
            String payload = new String(message.getPayload());
            pay=payload;
        }
    };

}
