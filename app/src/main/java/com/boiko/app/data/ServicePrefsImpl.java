package com.boiko.app.data;

import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

public class ServicePrefsImpl implements ServicePrefs {

    @Inject
    public ServicePrefsImpl() {
    }

    @Override
    public void saveToken(String token) {
        Prefs.putString(user_token, token);
    }

    @Override
    public String getUserToken() {
        if (Prefs.getString(user_token,null) == null)
            return null;
        else {
            return Prefs.getString(user_token, "");
        }
    }
}
