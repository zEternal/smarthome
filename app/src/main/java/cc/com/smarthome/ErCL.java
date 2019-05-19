package cc.com.smarthome;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ErCL extends AppCompatActivity {

    private Button er_cl1k;
    private Button er_cl1g;

    private boolean er_cl1_zt = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MqttManager mqttManager = new cc.com.smarthome.MqttManager(this);
        mqttManager.connect();//连接MQTT服务器
        setContentView(R.layout.er_cl);

        er_cl1k = (Button) findViewById(R.id.er_cl1k);
        er_cl1g = (Button) findViewById(R.id.er_cl1g);

        er_cl1k.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        mqttManager.publish("kaiguan","h",false,0);
                        er_cl1k.setBackgroundResource(R.mipmap.sw1);
                        break;
                    case MotionEvent.ACTION_UP:
                        mqttManager.publish("kaiguan","o",false,0);
                        er_cl1k.setBackgroundResource(R.mipmap.sw0);
                        break;
                }
                return false;
            }
        });

        er_cl1g.setOnTouchListener(new Button.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        mqttManager.publish("kaiguan","g",false,0);
                        er_cl1g.setBackgroundResource(R.mipmap.sw1);
                        break;
                    case MotionEvent.ACTION_UP:
                        mqttManager.publish("kaiguan","o",false,0);
                        er_cl1g.setBackgroundResource(R.mipmap.sw0);
                        break;
                }
                return false;
            }
        });
    }
}
