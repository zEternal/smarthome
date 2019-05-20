package cc.com.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button c1;
    private Button c2;
    private Button shezhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = (Button) findViewById(R.id.c1) ;
        c2 = (Button) findViewById(R.id.c2) ;
        shezhi = (Button) findViewById(R.id.shezhi);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, YiCeng.class);
                startActivity(intent);

            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ErCeng.class);
                startActivity(intent);

            }
        });

        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SetUp.class);
                startActivity(intent);
            }
        });
    }
}
