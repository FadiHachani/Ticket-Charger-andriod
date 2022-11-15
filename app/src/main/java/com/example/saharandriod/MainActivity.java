package com.example.saharandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);


        Button Login_btn=(Button) findViewById(R.id.Login_btn);


        Login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("sahar") && password.getText().toString().equals("123456"))
                    opendailer();

            }
        });


    }

    private void opendailer() {
        Intent intent = new Intent(this, dialer.class);
        startActivity(intent);
    }
}