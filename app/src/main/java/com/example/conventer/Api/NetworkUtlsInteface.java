package com.example.conventer.Api;

import com.example.conventer.pojo.DailyCurrencyFile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkUtlsInteface {
    @GET("daily_json.js")
    Call<DailyCurrencyFile> getCurrencies();
}
