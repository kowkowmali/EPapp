package com.example.haftsadbist;

import com.example.haftsadbist.models.ChargeRequest;
import com.example.haftsadbist.models.ChargeResponse;
import com.example.haftsadbist.models.Phone;
import com.example.haftsadbist.models.Root;
import com.example.haftsadbist.models.TranslationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIendpoint {
    @POST("Inquiry/FixedLineBillInquiry")
    Call<Root> getInquiry(@Body Phone phone);

    @POST(".")
    Call<ChargeResponse> getChargeUrl(@Body ChargeRequest chargeRequest);

    @POST("translate/")
    Call<TranslationResponse> getTranslation(@Query("token") String token,@Query("action") String action,@Query("lang") String lang, @Query("q") String text);
}
