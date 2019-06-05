package com.yhtos.intelligentlighting;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button b01;
    private Button b02;
    private Button b03;
    private Button b04;
    private Button b05;
    private Button b06;
    private Button b07;
    private Button b08;
    private Button b09;

    private Button cr;
    private Button cg;
    private Button cb;

    private Button acs;
    private TextView cs;

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

        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b03 = (Button) findViewById(R.id.b03);
        b04 = (Button) findViewById(R.id.b04);
        b05 = (Button) findViewById(R.id.b05);
        b06 = (Button) findViewById(R.id.b06);
        b07 = (Button) findViewById(R.id.b07);
        b08 = (Button) findViewById(R.id.b08);
        b09 = (Button) findViewById(R.id.b09);

        cr = (Button) findViewById(R.id.cr);
        cg = (Button) findViewById(R.id.cg);
        cb = (Button) findViewById(R.id.cb);

        acs = (Button) findViewById(R.id.acs);
        cs = (TextView) findViewById(R.id.cs);

        mqttManager.subscribe("wendu",0);

        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","0",false,0);
            }
        });

        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","1",false,0);
            }
        });

        b03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","2",false,0);
            }
        });

        b04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","3",false,0);
            }
        });

        b05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","4",false,0);
            }
        });

        b06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","5",false,0);
            }
        });

        b07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","6",false,0);
            }
        });

        b08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","7",false,0);
            }
        });

        b09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mqttManager.publish("kaiguan","8",false,0);
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

        acs.setOnTouchListener(new View.OnTouchListener() {
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
        });
    }
}
