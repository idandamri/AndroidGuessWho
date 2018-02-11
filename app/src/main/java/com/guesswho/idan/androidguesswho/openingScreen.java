package com.guesswho.idan.androidguesswho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.guesswho.idan.androidguesswho.Activities.BaseActivity;
import com.guesswho.idan.androidguesswho.Activities.CharecterSelectorScreen;
import com.guesswho.idan.androidguesswho.Activities.SettingsActivity;
import com.guesswho.idan.androidguesswho.Activities.Utils;

public class openingScreen extends BaseActivity {

    ImageView soundBtn, settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.setContext(getApplicationContext());
        Utils.setIsMuted(false);
        Utils.initMP();
        Utils.initDataSet();
        setContentView(R.layout.activity_main);
        Button playBtn = findViewById(R.id.play_btn);
        soundBtn = findViewById(R.id.sound_btn);
        settingsBtn = findViewById(R.id.settings_btn);
        Button tutorialBtn = findViewById(R.id.tutorial_btn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivity = new Intent(getApplicationContext(), CharecterSelectorScreen.class);
                startActivity(gameActivity);
            }
        });

        tutorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent settingsActivity = new Intent(getApplicationContext(), TutorialActivity.class);
//                startActivity(settingsActivity);
            }
        });

        soundBtn.setOnClickListener(new SoundListener(this.soundBtn));

        settingsBtn.setOnClickListener(settingaListener);
    }

    public static class SoundListener implements View.OnClickListener{

        private ImageView soundBtn;

        public SoundListener(ImageView soundBtn) {
            this.soundBtn = soundBtn;
        }

        @Override
        public void onClick(View v) {
            Utils.muteUnmuteSound();
            if (Utils.isMuted()) {
                soundBtn.setImageResource(R.drawable.ic_volume_up_black_24dp);
            } else {
                soundBtn.setImageResource(R.drawable.ic_volume_off_black_24dp);
            }
        }
    }

    public View.OnClickListener settingaListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent settingsActivity = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(settingsActivity);
        }
    };

//    @Override
//    protected void onPause() {
//        super.onPause();
//        Utils.pauseMusic();
//    }


    @Override
    protected void onStart() {
        super.onStart();
        Utils.unPauseMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.isMuted()) {
            soundBtn.setImageResource(R.drawable.ic_volume_up_black_24dp);
            Utils.pauseMusic();
        } else {
            soundBtn.setImageResource(R.drawable.ic_volume_off_black_24dp);
            Utils.unPauseMusic();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (!Utils.isMuted()) {
            soundBtn.setImageResource(R.drawable.ic_volume_up_black_24dp);
            Utils.pauseMusic();
        } else {
            soundBtn.setImageResource(R.drawable.ic_volume_off_black_24dp);
            Utils.unPauseMusic();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Utils.pauseMusic();
    }
}
