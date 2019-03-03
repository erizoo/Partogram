package com.boiko.app.data.network;

import com.boiko.app.data.models.RequestLogin;
import com.boiko.app.data.models.ResponseLogin;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiMethods {

    @POST("oauth2/token")
    Observable<Response<ResponseLogin>> login(@Header("Accept") String accept,
                                              @Body RequestLogin requestLogin);

    @GET("patients")
    Observable<Response<Void>> checkToken(@Header("Authorization") String userToken);
}
