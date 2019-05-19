package cc.com.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErCeng extends AppCompatActivity {

    //private Button c2_deng;
    private Button c2_chuang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.er_ceng);

        //c2_deng = (Button) findViewById(R.id.c2_deng);
        c2_chuang = (Button) findViewById(R.id.c2_chuang);

        c2_chuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ErCeng.this, ErCL.class);
                startActivity(intent);
            }
        });
    }
}
