package com.example.saharandriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class dialer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailer);
        TextView number =(TextView) findViewById(R.id.number);
        TextView code =(TextView) findViewById(R.id.code);
        TextView carrier =(TextView) findViewById(R.id.textView3) ;
        TextView coderecharge =(TextView) findViewById(R.id.textView4);
        TextView solde = (TextView) findViewById(R.id.textView5) ;
        Button apprecharge = (Button) findViewById(R.id.button);
        Button appsolde = (Button) findViewById(R.id.button1);



        number.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b ){

                    String text = number.getText().toString();
                    String recharge = code.getText().toString();
                    char first = text.charAt(0);
                    int n = Character.getNumericValue(first);

                   if (text.length() != 8) {

                       Toast errorToast = Toast.makeText(dialer.this, "Error, le nemuro de 8 chara", Toast.LENGTH_SHORT);
                       errorToast.show();

                   }else{

                        if (n == 2) {

                            carrier.setText("votre line est ooredoo");

                            solde.setText("*100#");

                            coderecharge.setText("*101*"+recharge+"#");


                            apprecharge.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + "*101*"+ recharge +"*#"));
                                    startActivity(intent);
                                }
                            });
                            appsolde.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + "*100"+"*#"));
                                    startActivity(intent);
                                }
                            });


                        }
                        if (n == 5) {
                            carrier.setText("votre line est orange");
                            coderecharge.setText("*100*"+recharge+"#");
                            solde.setText("*111#");
                            apprecharge.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + "*100*"+ recharge + "#"));
                                    startActivity(intent);
                                }
                            });
                            appsolde.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + "*111#"));
                                    startActivity(intent);
                                }
                            });
                        }
                        if (n == 9) {
                            carrier.setText("votre line est telecom");
                            coderecharge.setText("*123*"+recharge+"#");
                            solde.setText("*122#");
                            apprecharge.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + coderecharge));
                                    startActivity(intent);
                                }
                            });
                            appsolde.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:" + "*122"+"#"));
                                    startActivity(intent);
                                }
                            });
                        }
                    }


                }
            }
        });

    }
}