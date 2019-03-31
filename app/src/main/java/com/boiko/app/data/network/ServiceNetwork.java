package com.boiko.app.data.network;

import com.boiko.app.data.models.*;
import io.reactivex.Observable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

import java.util.List;

public interface ServiceNetwork {

    Observable<Response<ResponseLogin>> login(String login, String password);

    Observable<ResponseTransit> checkToken(String userToken);

    Observable<Response<List<ResponsePatient>>> getPatient(String userToken);

    Observable<ResponseTransit> getGoods();

    Observable<ResponseTransit> getSuppliers();
}
