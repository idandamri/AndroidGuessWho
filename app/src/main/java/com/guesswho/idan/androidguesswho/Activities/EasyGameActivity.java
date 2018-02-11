package com.guesswho.idan.androidguesswho.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.guesswho.idan.androidguesswho.CharacterCustomeView;
import com.guesswho.idan.androidguesswho.CharacterSelectObject;
import com.guesswho.idan.androidguesswho.CustomSpinnerAdapter;
import com.guesswho.idan.androidguesswho.R;
import com.guesswho.idan.androidguesswho.openingScreen;
import com.guesswho.idan.androidguesswho.openingScreen.SoundListener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EasyGameActivity extends BaseActivity {

    ArrayList<String> questions = new ArrayList<String>();
    CharacterSelectObject selected;
    private ImageView soundBtn, settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        selected = (CharacterSelectObject) getIntent().getSerializableExtra("selectedCard");

        //set content view AFTER ABOVE sequence (to avoid crash)
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        initViews();
    }

    private void initViews() {
        soundBtn = findViewById(R.id.sound_btn);
        settingsBtn = findViewById(R.id.settings_btn);
        soundBtn.setOnClickListener(new SoundListener(this.soundBtn));

//        settingsBtn.setOnClickListener(settingaListener);

        Spinner spinner = findViewById(R.id.quest_spinner);
        // Spinner Drop down elements
        createSpinnerElements();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this.getApplicationContext(), questions);
        spinner.setAdapter(customSpinnerAdapter);
        spinner.setOnItemSelectedListener(spinnerListener);

        CharacterCustomeView myCard = findViewById(R.id.my_selected_card);
        myCard.characterIV.setImageResource(selected.getImageName());
        myCard.charNameTV.setText(selected.getName());
        myCard.characterNoXContainer.setPadding(10,5,10,5);
        myCard.characterNoXContainer.setBackgroundResource(R.drawable.card_bg_basic);

        myCard.setIsClickable(false);
        myCard.getView().setOnClickListener(mySelectionCardListener);

        initCards();
//        myCard.setOnClickListener(mySelectionCardListener);
    }

    private void initCards() {
        try {
            CharacterCustomeView card;
            ArrayList<CharacterSelectObject> creationList = Utils.getDataSet();
            Collections.shuffle(creationList);

            String id;
            for (int i = 1; i <= 18; i++) {
                id = "card_" + i;
                int idInteger = getResources().getIdentifier(id, "id", getPackageName());
                card = findViewById(idInteger);
                card.charNameTV.setText(creationList.get(i-1).getName());
                card.characterIV.setImageResource(creationList.get(i-1).getImageName());
                card.characterNoXContainer.setBackgroundResource(R.drawable.card_bg_basic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSpinnerElements() {
        questions.add("Ashush");
        questions.add("Is");
        questions.add("The");
        questions.add("Most");
        questions.add("Beautiful");
        questions.add("Woman");
        questions.add("In");
        questions.add("The");
        questions.add("World");
    }

    public static AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String item = parent.getItemAtPosition(position).toString();

            Toast.makeText(parent.getContext(), "Android Custom Spinner Example Output..." + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public View.OnClickListener mySelectionCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Dialog settingsDialog = new Dialog(EasyGameActivity.this);

            settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

            LayoutInflater inflater = getLayoutInflater();
            View newView = (View) inflater.inflate(R.layout.profile_img_popup, null);
            CharacterCustomeView characterCustomeView = newView.findViewById(R.id.my_selected_dialog_card);
            TextView characterCustomeViewTitle = newView.findViewById(R.id.my_choice_card);
            characterCustomeViewTitle.setText(R.string.my_choice);
            characterCustomeView.setIVResource(selected.getImageName());
            characterCustomeView.setIsClickable(false);
            characterCustomeView.setCharecterName(selected.getName());
            settingsDialog.setContentView(newView);

            characterCustomeView.setSoundEffectsEnabled(false);
            settingsDialog.show();
        }
    };


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

}
