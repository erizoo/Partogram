package com.boiko.app.data.network;

import com.boiko.app.data.models.*;
import io.reactivex.Observable;
import retrofit2.Response;

import javax.inject.Inject;
import java.util.List;

public class ServiceNetworkImp implements ServiceNetwork {

    private static final String ACCEPT_HEADER = "application/json";

    private ApiMethods apiMethods;

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }


    @Override
    public Observable<Response<ResponseLogin>> login(String login, String password) {
        RequestLogin requestLogin = new RequestLogin();
        requestLogin.setLogin(login);
        requestLogin.setPassword(password);
        requestLogin.setClientId("testclient");
        requestLogin.setClientSecret("testpass");
        requestLogin.setType("password");
        return apiMethods.login(ACCEPT_HEADER, requestLogin);
    }

    @Override
    public Observable<ResponseTransit> checkToken(String userToken) {
        return apiMethods.getSuppliers();
    }

    @Override
    public Observable<Response<List<ResponsePatient>>> getPatient(String userToken) {
        return apiMethods.getPatient(userToken);
    }

    @Override
    public Observable<ResponseTransit> getGoods() {
        return apiMethods.getGoods();
    }

    @Override
    public Observable<ResponseTransit> getSuppliers() {
        return apiMethods.getSuppliers();
    }
}
