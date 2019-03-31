package com.boiko.app.data.network;

import com.boiko.app.data.models.*;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;

public interface ApiMethods {

    @POST("oauth2/token")
    Observable<Response<ResponseLogin>> login(@Header("Accept") String accept,
                                              @Body RequestLogin requestLogin);

    @GET("patients")
    Observable<Response<List<ResponsePatient>>> checkToken(@Header("Authorization") String userToken);

    @GET("patients")
    Observable<Response<List<ResponsePatient>>> getPatient(@Header("Authorization") String userToken);

    @GET("test_api_transit")
    Observable<ResponseTransit> getGoods();

    @GET("test_api_transit")
    Observable<ResponseTransit> getSuppliers();

    @FormUrlEncoded
    @POST("test_api_transit_to_stock")
    Observable<ResponseDebit> sendDebit(@Header("Content-Type") String content,
                                        @Field("skus") String request);
}
