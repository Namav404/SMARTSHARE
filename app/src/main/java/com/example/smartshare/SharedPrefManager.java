package com.example.smartshare;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
public class SharedPrefManager {
    private static final String SHARED_PREF_NAME = "smartshare";
    private static final String KEY_Name = "keyName";
    private static final String KEY_Email = "keyEmail";
    private static final String KEY_Enroll = "keyEnroll";
    private static final String KEY_Phone = "keyPhone";
    private static final String KEY_ID = "keyid";

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }
    public void userLogin(User user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_Name, user.getName());
        editor.putString(KEY_Email, user.getEmail());
        editor.putString(KEY_Phone, user.getPhone());
        editor.putString(KEY_Enroll, user.getEnroll());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_Email, null) != null;
    }

    //this method will give the logged in user
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_Enroll, null),
                sharedPreferences.getString(KEY_Name, null),
                sharedPreferences.getString(KEY_Email, null),
                sharedPreferences.getString(KEY_Phone, null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }
}
