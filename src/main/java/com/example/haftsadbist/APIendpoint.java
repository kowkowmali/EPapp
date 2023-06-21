package com.example.haftsadbist;

import com.example.haftsadbist.models.ChargeRequest;
import com.example.haftsadbist.models.ChargeResponse;
import com.example.haftsadbist.models.Phone;
import com.example.haftsadbist.models.Root;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIendpoint {
    @POST("Inquiry/FixedLineBillInquiry")
    Call<Root> getInquiry(@Body Phone phone);

    @POST("/")
    Call<ChargeResponse> getChargeUrl(@Body ChargeRequest chargeRequest);
}
