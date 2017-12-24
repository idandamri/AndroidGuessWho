package com.guesswho.idan.androidguesswho.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guesswho.idan.androidguesswho.Activities.BaseActivity;
import com.guesswho.idan.androidguesswho.R;

public class GameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
