package com.boiko.app.data.network;

import com.boiko.app.data.models.ResponseLogin;
import io.reactivex.Observable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

public interface ServiceNetwork {

    Observable<Response<ResponseLogin>> login(String login, String password);

    Observable<Response<Void>> checkToken(String userToken);
}
