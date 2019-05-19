package cc.com.smarthome;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YiD extends AppCompatActivity {

    private Button yi_zw;
    private Button yi_kw;
    private Button yi_cw;
    private Button yi_kt;
    private Button yi_ct;
    private Button yi_ys;

    //按钮状态
    private boolean yi_zw_zt = false;
    private boolean yi_kw_zt = false;
    private boolean yi_cw_zt = false;
    private boolean yi_kt_zt = false;
    private boolean yi_ct_zt = false;
    private boolean yi_ys_zt = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final MqttManager mqttManager = new cc.com.smarthome.MqttManager(this);
        mqttManager.connect();//连接MQTT服务器

        //获取sharedPreferences对象
        SharedPreferences sharedPreferences = getSharedPreferences("com.cc.mqtt_3",0);
        //获取sharedPreferences数据
        boolean yi_zw_zt1 = sharedPreferences.getBoolean("yi_zw_zt",false);
        boolean yi_kw_zt1 = sharedPreferences.getBoolean("yi_kw_zt",false);
        boolean yi_cw_zt1 = sharedPreferences.getBoolean("yi_cw_zt",false);
        boolean yi_kt_zt1 = sharedPreferences.getBoolean("yi_kt_zt",false);
        boolean yi_ct_zt1 = sharedPreferences.getBoolean("yi_ct_zt",false);
        boolean yi_ys_zt1 = sharedPreferences.getBoolean("yi_ys_zt",false);

        //将按钮状态赋值给全局变量，用作标志位
        yi_zw_zt = yi_zw_zt1;
        yi_kw_zt = yi_kw_zt1;
        yi_cw_zt = yi_cw_zt1;
        yi_kt_zt = yi_kt_zt1;
        yi_ct_zt = yi_ct_zt1;
        yi_ys_zt = yi_ys_zt1;

        //加载布局
        setContentView(R.layout.yi_d);

        //获取按钮
        yi_zw = (Button) findViewById(R.id.yi_zw);
        yi_kw = (Button) findViewById(R.id.yi_kw);
        yi_cw = (Button) findViewById(R.id.yi_cw);
        yi_kt = (Button) findViewById(R.id.yi_kt);
        yi_ct = (Button) findViewById(R.id.yi_ct);
        yi_ys = (Button) findViewById(R.id.yi_ys);

        //根据标志初始化按钮颜色
        if(yi_zw_zt)
            yi_zw.setBackgroundResource(R.mipmap.sw1);
        if(yi_kw_zt)
            yi_kw.setBackgroundResource(R.mipmap.sw1);
        if(yi_cw_zt)
            yi_cw.setBackgroundResource(R.mipmap.sw1);
        if(yi_kt_zt)
            yi_kt.setBackgroundResource(R.mipmap.sw1);
        if(yi_ct_zt)
            yi_ct.setBackgroundResource(R.mipmap.sw1);
        if(yi_ys_zt)
            yi_ys.setBackgroundResource(R.mipmap.sw1);
        //使sharedPreferences处于编辑状态
        final SharedPreferences.Editor editor = sharedPreferences.edit();


        yi_zw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_zw_zt)  {
                    mqttManager.publish("kaiguan","c",false,0);
                    yi_zw.setBackgroundResource(R.mipmap.sw0);
                    yi_zw_zt = false;
                    editor.putBoolean("yi_zw_zt",false);//异步存储
                }  else  {
                    mqttManager.publish("kaiguan","3",false,0);
                    yi_zw.setBackgroundResource(R.mipmap.sw1);
                    yi_zw_zt = true;
                    editor.putBoolean("yi_zw_zt",true);
                }
                editor.apply();
            }
        });

        yi_kw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_kw_zt)  {
                    mqttManager.publish("kaiguan","b",false,0);
                    yi_kw.setBackgroundResource(R.mipmap.sw0);
                    yi_kw_zt = false;
                    editor.putBoolean("yi_kw_zt",false);
                }  else  {
                    mqttManager.publish("kaiguan","2",false,0);
                    yi_kw.setBackgroundResource(R.mipmap.sw1);
                    yi_kw_zt = true;
                    editor.putBoolean("yi_kw_zt",true);
                }
                editor.apply();
            }
        });

        yi_cw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_cw_zt)  {
                    mqttManager.publish("kaiguan","a",false,0);
                    yi_cw.setBackgroundResource(R.mipmap.sw0);
                    yi_cw_zt = false;
                    editor.putBoolean("yi_cw_zt",false);
                }  else  {
                    mqttManager.publish("kaiguan","1",false,0);
                    yi_cw.setBackgroundResource(R.mipmap.sw1);
                    yi_cw_zt = true;
                    editor.putBoolean("yi_cw_zt",true);
                }
                editor.apply();
            }
        });

        yi_kt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_kt_zt)  {
                    mqttManager.publish("kaiguan","f",false,0);
                    yi_kt.setBackgroundResource(R.mipmap.sw0);
                    yi_kt_zt = false;
                    editor.putBoolean("yi_kt_zt",false);
                }  else  {
                    mqttManager.publish("kaiguan","6",false,0);
                    yi_kt.setBackgroundResource(R.mipmap.sw1);
                    yi_kt_zt = true;
                    editor.putBoolean("yi_kt_zt",true);
                }
                editor.apply();
            }
        });

        yi_ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_ct_zt)  {
                    mqttManager.publish("kaiguan","e",false,0);
                    yi_ct.setBackgroundResource(R.mipmap.sw0);
                    yi_ct_zt = false;
                    editor.putBoolean("yi_ct_zt",false);
                }  else  {
                    mqttManager.publish("kaiguan","5",false,0);
                    yi_ct.setBackgroundResource(R.mipmap.sw1);
                    yi_ct_zt = true;
                    editor.putBoolean("yi_ct_zt",true);
                }
                editor.apply();
            }
        });

        yi_ys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(yi_ys_zt)  {
                    mqttManager.publish("kaiguan","d",false,0);
                    yi_ys.setBackgroundResource(R.mipmap.sw0);
                    yi_ys_zt = false;
                    editor.putBoolean("yi_ys_zt",false);
                }  else  {
                    mqttManager.publish("kaiguan","4",false,0);
                    yi_ys.setBackgroundResource(R.mipmap.sw1);
                    yi_ys_zt = true;
                    editor.putBoolean("yi_ys_zt",true);
                }
                editor.apply();
            }
        });
    }
}
