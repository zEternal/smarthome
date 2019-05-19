package cc.com.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2500);//使程序休眠五秒
                    Intent it = new Intent(Splash.this,MainActivity.class);//启动MainActivity
                    startActivity(it);
                    finish();//关闭当前活动
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        myThread.start();//启动线程
    }
}
