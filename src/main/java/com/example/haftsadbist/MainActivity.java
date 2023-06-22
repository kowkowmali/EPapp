package com.example.haftsadbist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haftsadbist.models.Phone;
import com.example.haftsadbist.models.Root;
import com.example.haftsadbist.models.TranslationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageButton translateBtn, fixedTelBtn, chargeBtn;
    EditText inputEt;
    TextView translateTv;
    Context context =this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixedTelBtn = findViewById(R.id.telBtn1);
        chargeBtn = findViewById(R.id.chrgBtn1);
        translateBtn = findViewById(R.id.translateBtn);
        inputEt = findViewById(R.id.editTextText);
        translateTv = findViewById(R.id.translateTv);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://one-api.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIendpoint apiService = retrofit.create(APIendpoint.class);


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

        translateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.getTranslation(getResources().getString(R.string.ONE_API_TOKEN), "google", "fa",inputEt.getText().toString()).enqueue(new Callback<TranslationResponse>() {
                    @Override
                    public void onResponse(Call<TranslationResponse> call, Response<TranslationResponse> response) {
                        if(response.body().status!=200){
                            Toast.makeText(context,  "ترجمه به مشکل خورد " + response.body().status, Toast.LENGTH_LONG).show();
                        }else{
                            translateTv.setText(response.body().result);
                        }
                    }
                    @Override
                    public void onFailure(Call<TranslationResponse> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}