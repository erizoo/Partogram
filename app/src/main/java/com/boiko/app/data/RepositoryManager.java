package com.boiko.app.data;


import com.boiko.app.data.network.ServiceNetwork;

public interface RepositoryManager {

    ServiceNetwork getServiceNetwork();

    ServicePrefs getServicePrefs();

    void setToken(String token);
}
