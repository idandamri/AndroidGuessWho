package com.guesswho.idan.androidguesswho;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guesswho.idan.androidguesswho.Activities.Utils;

/**
 * Created by Idan on 11/01/2018.
 */

public class CharacterCustomeView extends RelativeLayout {

    private View view;
    public ImageView characterIV, xIV;
    public TextView charNameTV;
    String charecterName = "";
    boolean isCharacterMarked = false;
    int charecterPosition = -1;


    public CharacterCustomeView(Context context) {
        super(context, null);
        view = inflate(getContext(), R.layout.character_view, null);
        addView(view);
        initView();
    }

    public CharacterCustomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = inflate(getContext(), R.layout.character_view, null);
        addView(view);
        initView();
    }

    public CharacterCustomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        view = inflate(getContext(), R.layout.character_view, null);
        addView(view);
        initView();
    }

    OnClickListener charecterClickListener = new OnClickListener() {

        @Override
        public void onClick(View view) {
            if (view != null) {
                if(!isCharacterMarked()){
                    view.findViewById(R.id.cover_x_charachter).setVisibility(VISIBLE);
                    setCharacterMarked(true);
                }
                else{
                    view.findViewById(R.id.cover_x_charachter).setVisibility(INVISIBLE);
                    setCharacterMarked(false);
                }
            }
        }
    };

    private void initView() {
        characterIV = view.findViewById(R.id.character_item);
        characterIV.setImageResource(R.mipmap.dumb_icon);
        xIV = view.findViewById(R.id.cover_x_charachter);
        xIV.setImageResource(R.drawable.circle_x);
        xIV.setVisibility(INVISIBLE);
        view.setOnClickListener(charecterClickListener);
    }

    public static CharacterCustomeView newInstance(String name, int position, boolean isCharacterMarked) {
        CharacterCustomeView retVal = null;
        try {
            retVal = new CharacterCustomeView(Utils.getContext());
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
