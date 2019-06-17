package com.yhtos.intelligentlighting;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {

    private Button cr;
    private Button cg;
    private Button cb;

    private VerticalSeekBar seekBar;

    private Button acs;
    private static TextView cs;

    private String pay;

    String[] ss =new String[]{ "0","1","2","3","4","5","6","7","8","9","p"
            ,"o","i","u","y","t","l","k","j","h"};

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String payload = bundle.getString("payload");

            cs.setText(payload);
        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MqttManager mqttManager = new MqttManager(this);
        SharedPreferences sharedPreferences = getSharedPreferences("setting",0);
        String host = sharedPreferences.getString("url","tcp://shiyan.mqtt.iot.bj.baidubce.com:1883");
        String userName = sharedPreferences.getString("user","shiyan/esp8266");
        String passWord = sharedPreferences.getString("pass","5FyadUaBpe0RKi7rWBiJQLj+YMFGbsW0/pHZ55KlqAM=");

        mqttManager.connect(host,userName,passWord);

        cr = (Button) findViewById(R.id.cr);
        cg = (Button) findViewById(R.id.cg);
        cb = (Button) findViewById(R.id.cb);

        acs = (Button) findViewById(R.id.acs);
        cs = (TextView) findViewById(R.id.cs);

        seekBar = (VerticalSeekBar) findViewById(R.id.seekbar);

        mqttManager.subscribe("wendu",0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.e("xyh", "onProgressChanged: " + i + "");
                //String s = String.valueOf(i);
                mqttManager.publish("kaiguan",ss[i],false,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("xyh", "onStartTrackingTouch: " + "开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("xyh", "onStartTrackingTouch: " + "结束拖动");
            }
        });

        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","r",false,0);
            }
        });

        cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","g",false,0);
            }
        });

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","b",false,0);
            }
        });

        /*acs.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        mqttManager.publish("kaiguan","c",false,0);
                        break;
                    case MotionEvent.ACTION_UP:
                        cs.setText(mqttManager.pay);
                        break;
                }
                return false;
            }
        });*/



        acs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","c",false,0);
                try {
                    Thread.sleep(3000);
                    cs.setText(mqttManager.pay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
