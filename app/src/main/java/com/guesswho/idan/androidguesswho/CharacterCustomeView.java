package com.guesswho.idan.androidguesswho;

import android.app.Dialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guesswho.idan.androidguesswho.Activities.BaseActivity;
import com.guesswho.idan.androidguesswho.Activities.Utils;

import java.lang.ref.WeakReference;

/**
 * Created by Idan on 11/01/2018.
 */

public class CharacterCustomeView extends RelativeLayout {

    private View view;
    public ImageView characterIV, xIV;
    public TextView charNameTV;
    String charecterName = "";
    WeakReference<BaseActivity> weakReference;
    boolean isCharacterMarked = false;
    boolean isClickable = true;
    int charecterPosition = -1;
    CharacterSelectObject characterSelectObject;
    public LinearLayout characterNoXContainer;
    private int imageResource;
    private boolean isSelected = false;

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
            if (isClickable) {
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
        }
    };

    private void initView() {
        characterNoXContainer = view.findViewById(R.id.character_container);
        characterIV = view.findViewById(R.id.character_item_iv);
        charNameTV = view.findViewById(R.id.character_name);
        characterIV.setImageResource(R.mipmap.dumb_icon);
        xIV = view.findViewById(R.id.cover_x_charachter);
        xIV.setImageResource(R.drawable.circle_x);
        xIV.setVisibility(INVISIBLE);
        if(getIsClickable()) {
            if (isSelected) {
                view.setOnClickListener(selectedClickListener);
            } else {
                view.setOnClickListener(charecterClickListener);
                view.setOnLongClickListener(longPressClickListener);
            }
        }
    }

    public void openPressenCardDialog(Context context, CharacterSelectObject selected) {
        Dialog pressedCardDialog = new Dialog(weakReference.get());

        pressedCardDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        LayoutInflater inflater = weakReference.get().getLayoutInflater();
        View newView = (View) inflater.inflate(R.layout.profile_img_popup, null);
        CharacterCustomeView characterCustomeView = newView.findViewById(R.id.my_selected_dialog_card);
        TextView characterCustomeViewTitle = newView.findViewById(R.id.my_choice_card);
        characterCustomeViewTitle.setText(R.string.my_choice);
        characterCustomeView.setIVResource(selected.getImageName());
        characterCustomeView.setIsClickable(false);
        characterCustomeView.setCharecterName(selected.getName());
        pressedCardDialog.setContentView(newView);

        characterCustomeView.setSoundEffectsEnabled(false);
        pressedCardDialog.show();
    }


    public static CharacterCustomeView newInstance(String name, int position, boolean isCharacterMarked, boolean isClickable) {
        CharacterCustomeView retVal = null;
        try {
            retVal = new CharacterCustomeView(Utils.getContext());
            retVal.setCharacterMarked(isCharacterMarked);
            retVal.setCharecterName(name);
            retVal.setCharecterPosition(position);
            retVal.setIsClickable(isClickable);
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
        this.charNameTV.setText(charecterName);
    }

    public void setIVResource(int src) {
        characterIV.setImageResource(src);
    }

    public void setCharacterMarked(boolean characterMarked) {
        isCharacterMarked = characterMarked;
    }

    public void setCharecterPosition(int charecterPosition) {
        this.charecterPosition = charecterPosition;
    }

    public void setIsClickable(boolean isClickable) {
        if(!isClickable){
            this.isClickable = false;
            this.setOnClickListener(null);
        }
    }

    public boolean getIsClickable() {
        return isClickable;
    }

    public View getView() {
        return view;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public WeakReference<BaseActivity> getWeakReference() {
        return weakReference;
    }

    public void setWeakReference(BaseActivity ref) {
        this.weakReference = new WeakReference<>(ref);
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public CharacterSelectObject getCharacterSelectObject() {
        return characterSelectObject;
    }

    public void setCharacterSelectObject(CharacterSelectObject characterSelectObject) {
        this.characterSelectObject = characterSelectObject;
    }

    public OnClickListener selectedClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            openPressenCardDialog(Utils.getContext(),getCharacterSelectObject());
        }
    };

    private OnLongClickListener longPressClickListener = new OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            openPressenCardDialog(Utils.getContext(),getCharacterSelectObject());
            return true;
        }
    };

}
