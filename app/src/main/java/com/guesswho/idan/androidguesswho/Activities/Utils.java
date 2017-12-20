package com.guesswho.idan.androidguesswho.Activities;

import android.media.MediaPlayer;

/**
 * Created by Idan on 20/12/2017.
 */

public class Utils {

    public static boolean isMuted() {
        return isMuted;
    }

    public static void setIsMuted(boolean isMuted) {
        Utils.isMuted = isMuted;
    }

    public static boolean isMuted = false;

    public static MediaPlayer mediaPlayer;

    public static void initMP(){
        mediaPlayer = new MediaPlayer();
    }

    public static boolean muteUnmuteSound(){
        try {
            if(isMuted()){
                mediaPlayer.setVolume(0,1);
                setIsMuted(false);
            }
            else {
                mediaPlayer.setVolume(0,0);
                setIsMuted(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isMuted();
    }

}
