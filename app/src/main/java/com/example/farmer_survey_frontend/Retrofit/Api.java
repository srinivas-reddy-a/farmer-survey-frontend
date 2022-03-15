package com.example.farmer_survey_frontend.Retrofit;

import com.example.farmer_survey_frontend.Respones.GetFarmerDataRespones;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("/api/user/")
    Call<ResponseBody>postFarmerData(@Field("name") String name,
                                     @Field("number") String number,
                                     @Field("village") String village,
                                     @Field("pincode") String pincode,
                                     @Field("problems") String problems,
                                     @Field("needs") String needs);

    @GET("/api/user/")
    Call<GetFarmerDataRespones>getData();
}
