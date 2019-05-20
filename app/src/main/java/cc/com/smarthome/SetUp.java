package cc.com.smarthome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetUp extends AppCompatActivity {

    private EditText host;
    private EditText user;
    private EditText pass;
    private Button baocun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        host = (EditText) findViewById(R.id.url);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        baocun = (Button) findViewById(R.id.baocun);





        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("com.cc.mqtt_3",0);
                String hosts = host.getText().toString();
                String userNames = user.getText().toString();
                String passWords = pass.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("url",hosts);
                editor.putString("user",userNames);
                editor.putString("pass",passWords);

                editor.apply();

                Intent intent = new Intent(SetUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
