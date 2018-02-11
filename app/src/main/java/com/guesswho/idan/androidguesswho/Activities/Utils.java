package com.guesswho.idan.androidguesswho.Activities;

import android.content.Context;
import android.media.MediaPlayer;

import com.guesswho.idan.androidguesswho.CharacterSelectObject;
import com.guesswho.idan.androidguesswho.CharacteristicObj;
import com.guesswho.idan.androidguesswho.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Idan on 20/12/2017.
 */

public class Utils {

    private static ArrayList<CharacterSelectObject> DataSet;

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
        mediaPlayer = MediaPlayer.create(getContext(),R.raw.bg_2);
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

    public static void initDataSet() {
        DataSet = new ArrayList<>();

        CharacterSelectObject charObj;
        HashMap<Integer, CharacteristicObj> MapChar = new HashMap<>();
        int id = 1;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.bear),R.drawable.bear);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.bunny),R.drawable.bunny);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.cheetah),R.drawable.cheetah);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.chick),R.drawable.chick);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.cow),R.drawable.cow);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.duckling),R.drawable.duckling);
//        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.deer),R.drawable.deer);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.elephant),R.drawable.elephant);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.fish),R.drawable.fish);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.flamingo),R.drawable.flamingo);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.fox),R.drawable.fox);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.giraffe),R.drawable.giraffe);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.horse),R.drawable.horse);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.lion),R.drawable.lion);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.mouse),R.drawable.mouse);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.owl),R.drawable.owl);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.panda),R.drawable.panda);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.panther),R.drawable.panther);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.pig),R.drawable.pig);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.rhino),R.drawable.rhino);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.shark),R.drawable.shark);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.sheep),R.drawable.sheep);
        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.snake),R.drawable.snake);
//        DataSet.add(charObj);
//        id++;
//        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.tiger),R.drawable.tiger);
//        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.turtle),R.drawable.turtle);
        DataSet.add(charObj);
        id++;
        charObj = new CharacterSelectObject(id,MapChar,getContext().getString(R.string.zebra),R.drawable.zebra);
        DataSet.add(charObj);
    }

    public static ArrayList<CharacterSelectObject> getDataSet() {
        return DataSet;
    }

}
