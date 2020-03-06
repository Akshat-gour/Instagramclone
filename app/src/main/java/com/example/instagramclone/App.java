package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ng0bDeCryUPf5nguUBgPon1brGqWFeMyyKrAC3r3")
                // if defined
                .clientKey("Pf3kgHu88cw0S01B9cZQu04rFjyORt7JoucMycHM")
                .server("https://parseapi.back4app.com/")
                .build());
    }
}
