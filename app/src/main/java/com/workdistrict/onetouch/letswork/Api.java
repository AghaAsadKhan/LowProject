package com.workdistrict.onetouch.letswork;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("signup.php")
    Call<Pojo_SignUp> signUp(@Body Pojo_SignUp pojoSignUp);
    Call<Pojo_Login> logIn(@Body Pojo_Login pojoLogin);
}
