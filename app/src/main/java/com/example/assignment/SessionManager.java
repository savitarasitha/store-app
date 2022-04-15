package com.example.assignment;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    SharedPreferences preferences;
    Context context;
    public static String APP_NAME = "Assignment";
    final String IS_LOGIN = "Assignment";

    public SessionManager(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(APP_NAME, context.MODE_PRIVATE);
    }

    public void setBoolean(Boolean isLoggedIn) {
        preferences.edit().putBoolean(IS_LOGIN, isLoggedIn).apply();
    }

    public Boolean getBoolean() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void setString(String myString){
        preferences.edit().putString("MyString" , myString).apply();
    }

    public String getString(){
        return  preferences.getString("MyString" ,"");
    }

}
