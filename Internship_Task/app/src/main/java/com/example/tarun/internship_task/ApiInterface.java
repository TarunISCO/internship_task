package com.example.tarun.internship_task;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("jsonparsetutorial.txt")
    Call<UrlResponse> getCountries();
}
