package com.example.haftsadbist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button fixedTelBtn, chargeBtn;
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixedTelBtn = findViewById(R.id.telBtn);
        chargeBtn = findViewById(R.id.chrgBtn);

        fixedTelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, TelActivity.class);
                startActivity(in);
            }
        });

        chargeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(context, ChargeActivity.class);
                startActivity(in);
            }
        });
    }
}