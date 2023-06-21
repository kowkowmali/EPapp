package com.example.haftsadbist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.haftsadbist.models.Phone;
import com.example.haftsadbist.models.Root;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelActivity extends AppCompatActivity {

    EditText et;
    Button submitButton;
    Context context = this;
    public static final String INQUIRY_CODE = "INQUIRY_CODE";
    public static final String MIDTERM_AMOUNT = "MIDTERM_AMOUNT";
    public static final String MIDTERM_CODE = "MIDTERM_CODE";
    public static final String MIDTERM_BILL = "MIDTERM_BILL";
    public static final String FINALTERM_AMOUNT = "FINALTERM_AMOUNT";
    public static final String FINALTERM_CODE = "FINALTERM_CODE";
    public static final String FINALTERM_BILL = "FINALTERM_BILL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel);

        et = findViewById(R.id.editTextPhone);
        submitButton = findViewById(R.id.submitButton);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://charge.sep.ir/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIendpoint apiService = retrofit.create(APIendpoint.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                apiService.getInquiry(new Phone(et.getText().toString())).enqueue(new Callback<Root>() {
                    @Override
                    public void onResponse(Call<Root> call, Response<Root> response) {
                        if(response.body().errorMessage!=null){
                            Toast.makeText(context, response.body().data.FinalTerm.Amount + '/' +response.body().errorMessage + '/' + response.body().code.toString(), Toast.LENGTH_LONG).show();
                        }else{
                            Intent in = new Intent(context, TelResultActivity.class);
                            in.putExtra(FINALTERM_CODE, response.body().data.FinalTerm.PaymentID);
                            in.putExtra(FINALTERM_AMOUNT, response.body().data.FinalTerm.Amount);
                            in.putExtra(FINALTERM_BILL, response.body().data.FinalTerm.BillID);
                            in.putExtra(MIDTERM_AMOUNT, response.body().data.MidTerm.Amount);
                            in.putExtra(MIDTERM_CODE, response.body().data.MidTerm.PaymentID);
                            in.putExtra(MIDTERM_BILL, response.body().data.MidTerm.BillID);
                            startActivity(in);
                        }
                    }

                    @Override
                    public void onFailure(Call<Root> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}