package com.example.smart_tv;

import com.example.smart_tv.LoginRequest;
import com.example.smart_tv.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {

    @POST("auth/login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);




}