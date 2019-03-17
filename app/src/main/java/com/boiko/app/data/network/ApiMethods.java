package com.boiko.app.data.network;

import android.widget.EditText;
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

    @POST("heart-beat-create")
    Observable<Response<ResponseStatus>> fetalHeartbeat(@Header("Authorization") String userToken,
                                                        @Body RequestFetalHeartbeat requestFetalHeartbeat);
    @GET("get-heart-partogramm-id/{id}")
    Observable<Response<List<ResponseFetalHeartbeat>>> getFetalHeartbeat(@Header("Authorization")String userToken,
                                                           @Path("id") Integer id);

    @GET("get-pulse-id/{id}")
    Observable<Response<List<ResponseFetalHeartbeat>>> getPulse(@Header("Authorization")String userToken,
                                                                @Path("id") Integer id);

    @POST("temperature-create")
    Observable<Response<ResponseStatus>> saveTemp(@Header("Authorization") String accept,
                                                  @Body RequestTemp requestTemp);

    @GET("get-temperature-id/{id}")
    Observable<Response<List<RequestTemp>>> getTemp(@Header("Authorization")String userToken,
                                              @Path("id") Integer id);
}
