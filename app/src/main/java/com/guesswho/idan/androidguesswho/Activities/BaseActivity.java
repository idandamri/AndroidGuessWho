package com.guesswho.idan.androidguesswho.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guesswho.idan.androidguesswho.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public boolean muteUnmute(){
        try {
            Utils.muteUnmuteSound();
            return Utils.isMuted();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Utils.isMuted();
    }

    public void openSettingsActivity(){
        try {
            Intent settingIntent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
