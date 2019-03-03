package com.boiko.app.data;

import com.boiko.app.data.network.ServiceNetwork;

import javax.inject.Inject;

public class RepositoryManagerImpl implements RepositoryManager {

    private ServiceNetwork serviceNetwork;
    private ServicePrefs servicePrefs;

    @Inject
    RepositoryManagerImpl(ServiceNetwork serviceNetwork, ServicePrefs servicePrefs) {
        this.serviceNetwork = serviceNetwork;
        this.servicePrefs = servicePrefs;
    }

    @Override
    public ServiceNetwork getServiceNetwork() {
        return serviceNetwork;
    }

    @Override
    public ServicePrefs getServicePrefs() {
        return servicePrefs;
    }

    @Override
    public void setToken(String token) {
        servicePrefs.saveToken(token);
    }
}
