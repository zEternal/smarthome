package cc.com.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YiCeng extends AppCompatActivity {

    private Button c1_deng;
    private Button c1_chuang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yi_ceng);

        c1_deng = (Button) findViewById(R.id.c1_deng);
        c1_chuang = (Button) findViewById(R.id.c1_chuang);

        c1_deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YiCeng.this, YiD.class);
                startActivity(intent);
            }
        });
    }
}
