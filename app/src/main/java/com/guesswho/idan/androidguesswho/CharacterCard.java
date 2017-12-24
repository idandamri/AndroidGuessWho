package com.guesswho.idan.androidguesswho;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.guesswho.idan.androidguesswho.Activities.Utils;

/**
 * Created by Idan on 21/12/2017.
 */

public class CharacterCard extends View {

    private View mView;
    String charecterName = "";

    boolean isCharacterMarked = false;
    int charecterPosition = -1;

    public CharacterCard(Context context) {
        super(context);
    }

    public CharacterCard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            mView = inflater.inflate(R.layout.character_view, null);
        }
    }

    public CharacterCard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            mView = inflater.inflate(R.layout.character_view, null);
        }
    }

    OnClickListener charecterClickListener = new OnClickListener() {

        @Override
        public void onClick(View view) {
            if (mView != null) {
                if(isCharacterMarked()){
                    mView.findViewById(R.id.cover_x_charachter).setVisibility(VISIBLE);
                }
                else{
                    mView.findViewById(R.id.cover_x_charachter).setVisibility(INVISIBLE);
                }
            }
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CharacterCard(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        LayoutInflater inflater;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            mView = inflater.inflate(R.layout.character_view, null);
        }

        if (mView != null) {
            mView.setOnClickListener(charecterClickListener);
        }
    }

    public static CharacterCard newInstance(String name, int position, boolean isCharacterMarked) {
        CharacterCard retVal = null;
        try {
            retVal = new CharacterCard(Utils.getContext(), null);
            retVal.setCharacterMarked(isCharacterMarked);
            retVal.setCharecterName(name);
            retVal.setCharecterPosition(position);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public String getCharecterName() {
        return charecterName;
    }

    public boolean isCharacterMarked() {
        return isCharacterMarked;
    }

    public int getCharecterPosition() {
        return charecterPosition;
    }


    public void setCharecterName(String charecterName) {
        this.charecterName = charecterName;
    }

    public void setCharacterMarked(boolean characterMarked) {
        isCharacterMarked = characterMarked;
    }

    public void setCharecterPosition(int charecterPosition) {
        this.charecterPosition = charecterPosition;
    }


}