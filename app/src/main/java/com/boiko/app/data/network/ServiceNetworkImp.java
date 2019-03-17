package com.boiko.app.data.network;

import com.boiko.app.data.models.*;
import io.reactivex.Observable;
import org.jetbrains.annotations.Nullable;
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
    public Observable<Response<List<ResponsePatient>>> checkToken(String userToken) {
        return apiMethods.checkToken(userToken);
    }

    @Override
    public Observable<Response<List<ResponsePatient>>> getPatient(String userToken) {
        return apiMethods.getPatient(userToken);
    }

    @Override
    public Observable<Response<ResponseStatus>> fetalHeartbeat(String userToken, Integer id, String edit_text, String format) {
        RequestFetalHeartbeat requestFetalHeartbeat = new RequestFetalHeartbeat();
        requestFetalHeartbeat.setId(id);
        requestFetalHeartbeat.setBeatsPerSecond(Integer.valueOf(edit_text));
        requestFetalHeartbeat.setTime(format);
        return apiMethods.fetalHeartbeat(userToken, requestFetalHeartbeat);
    }

    @Override
    public Observable<Response<List<ResponseFetalHeartbeat>>> getFetalHeartbeat(String userToken, Integer id) {
        return apiMethods.getFetalHeartbeat(userToken, id);
    }

    @Override
    public Observable<Response<List<ResponseFetalHeartbeat>>> getPulse(String userToken, Integer id) {
        return apiMethods.getPulse(userToken, id);
    }

    @Override
    public Observable<Response<ResponseStatus>> savePulse(String userToken, int id, String edit_text, String format) {
        RequestFetalHeartbeat requestFetalHeartbeat = new RequestFetalHeartbeat();
        requestFetalHeartbeat.setId(id);
        requestFetalHeartbeat.setBeatsPerSecond(Integer.valueOf(edit_text));
        requestFetalHeartbeat.setTime(format);
        return apiMethods.fetalHeartbeat(userToken, requestFetalHeartbeat);
    }

    @Override
    public Observable<Response<ResponseStatus>> saveTemp(String userToken, int id, String data, String format) {
        RequestTemp requestTemp = new RequestTemp();
        requestTemp.setId(id);
        requestTemp.setTemperature(Double.valueOf(data));
        requestTemp.setTime(format);
        return apiMethods.saveTemp(userToken, requestTemp);
    }

    @Override
    public Observable<Response<List<RequestTemp>>> getTemp(@Nullable String userToken, int idLabor) {
        return apiMethods.getTemp(userToken, idLabor);
    }
}
