package com.example.haftsadbist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.haftsadbist.models.ChargeRequest;
import com.example.haftsadbist.models.ChargeResponse;
import com.example.haftsadbist.models.Phone;
import com.example.haftsadbist.models.Root;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChargeActivity extends AppCompatActivity {

    EditText phoneNoEt, amountEt;
    RadioButton mciBtn, irancellBtn, rightellBtn;
    Button submitBtn;
    float operator;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);

        phoneNoEt = findViewById(R.id.editTextPhone2);
        amountEt = findViewById(R.id.editTextNumber);

        mciBtn = findViewById(R.id.mciBtn);
        irancellBtn = findViewById(R.id.irancellBtn);
        rightellBtn = findViewById(R.id.rightellBtn);

        submitBtn = findViewById(R.id.button2);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://topup.pec.ir")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIendpoint apiService = retrofit.create(APIendpoint.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((mciBtn.isChecked() || irancellBtn.isChecked() || rightellBtn.isChecked()) && amountEt.getText()!=null && phoneNoEt.getText()!=null) {
                    if(mciBtn.isChecked()){
                        operator = 0f;
                    }else if(irancellBtn.isChecked()){
                        operator = 1f;
                    }else if(rightellBtn.isChecked()){
                        operator = 2f;
                    }
                    apiService.getChargeUrl(new ChargeRequest(phoneNoEt.getText().toString(), operator, Float.parseFloat(amountEt.getText().toString()), "0")).enqueue(new Callback<ChargeResponse>() {
                        @Override
                        public void onResponse(Call<ChargeResponse> call, Response<ChargeResponse> response) {
                            if (response.body() == null) {
                                Toast.makeText(context, "درخواست به مشکل خورد", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show();
                                Uri uri = Uri.parse(response.body().url);
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);
                            }
                        }
                        @Override
                        public void onFailure(Call<ChargeResponse> call, Throwable t) {
                            Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(context, "اطلاعات را کامل وارد کنید", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}