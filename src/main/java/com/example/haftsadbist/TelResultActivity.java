package com.example.haftsadbist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TelResultActivity extends AppCompatActivity {

    TextView  fAmountTv, fIdTv, fBillTv, mAmountTv, mIdTv, mBillTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_result);

        mIdTv = findViewById(R.id.mianTextShenase);
        mAmountTv = findViewById(R.id.mianTextBedehi);
        mBillTv = findViewById(R.id.mianBillText);
        fIdTv = findViewById(R.id.payanTextShenase);
        fAmountTv = findViewById(R.id.payanTextBedehi);
        fBillTv = findViewById(R.id.payanBillText);

        if(getIntent().getStringExtra(TelActivity.MIDTERM_CODE)!=null) {
            mIdTv.append(getIntent().getStringExtra(TelActivity.MIDTERM_CODE));
        }
        if(getIntent().getStringExtra(TelActivity.MIDTERM_AMOUNT)!=null){
            mAmountTv.append(getIntent().getStringExtra(TelActivity.MIDTERM_AMOUNT));
        }
        if(getIntent().getStringExtra(TelActivity.MIDTERM_BILL)!=null){
            mBillTv.append(getIntent().getStringExtra(TelActivity.MIDTERM_BILL));
        }
        if(getIntent().getStringExtra(TelActivity.FINALTERM_CODE)!=null){
            fIdTv.append(getIntent().getStringExtra(TelActivity.FINALTERM_CODE));
        }
        if(getIntent().getStringExtra(TelActivity.FINALTERM_AMOUNT)!=null){
            fAmountTv.append(getIntent().getStringExtra(TelActivity.FINALTERM_AMOUNT));
        }
        if(getIntent().getStringExtra(TelActivity.FINALTERM_BILL)!=null){
            fBillTv.append(getIntent().getStringExtra(TelActivity.FINALTERM_BILL));
        }

    }
}