package com.boiko.app.data.network;

import com.boiko.app.data.models.*;
import io.reactivex.Observable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

import java.util.List;

public interface ServiceNetwork {

    Observable<Response<ResponseLogin>> login(String login, String password);

    Observable<Response<List<ResponsePatient>>> checkToken(String userToken);

    Observable<Response<List<ResponsePatient>>> getPatient(String userToken);

    Observable<Response<ResponseStatus>> fetalHeartbeat(String userToken, Integer id, String edit_text, String format);

    Observable<Response<List<ResponseFetalHeartbeat>>> getFetalHeartbeat(String userToken, Integer id);

    Observable<Response<List<ResponseFetalHeartbeat>>> getPulse(String userToken, Integer idLabor);

    Observable<Response<ResponseStatus>> savePulse(String userToken, int id, String edit_text, String format);

    Observable<Response<ResponseStatus>> saveTemp(String userToken, int id, String data, String format);

    Observable<Response<List<RequestTemp>>> getTemp(@Nullable String userToken, int idLabor);
}
