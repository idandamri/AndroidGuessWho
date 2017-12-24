package com.guesswho.idan.androidguesswho.Activities;

import android.content.Context;
import android.media.MediaPlayer;

import com.guesswho.idan.androidguesswho.R;

/**
 * Created by Idan on 20/12/2017.
 */

public class Utils {

    public static Context getContext() {
        return context;
    }

    private static Context context = null;

    public static boolean isMuted() {
        return isMuted;
    }

    public static void setIsMuted(boolean isMuted) {
        Utils.isMuted = isMuted;
    }

    public static boolean isMuted = false;

    public static MediaPlayer mediaPlayer;

    public static void initMP() {
        mediaPlayer = MediaPlayer.create(getContext(),R.raw.pom);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    public static boolean muteUnmuteSound() {
        try {
            if (isMuted()) {
                mediaPlayer.setVolume(0, 1);
                setIsMuted(false);
            } else {
                mediaPlayer.setVolume(0, 0);
                setIsMuted(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isMuted();
    }

    public static void setContext(Context contextNew) {
        context = contextNew;
    }

    public static void pauseMusic() {
        mediaPlayer.pause();
        setIsMuted(true);
    }

    public static void unPauseMusic() {
        setIsMuted(false);
        mediaPlayer.start();
    }
}
