package com.guesswho.idan.androidguesswho.Activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.guesswho.idan.androidguesswho.CharacterCustomeView;
import com.guesswho.idan.androidguesswho.CharacterSelectObject;
import com.guesswho.idan.androidguesswho.CustomSpinnerAdapter;
import com.guesswho.idan.androidguesswho.R;
import com.guesswho.idan.androidguesswho.Activities.openingScreen.SoundListener;
import com.guesswho.idan.androidguesswho.Utils;

import java.util.ArrayList;
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

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

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

        initSelectedCard();
        initCards();
    }

    private void initSelectedCard() {
        CharacterCustomeView myCard = findViewById(R.id.my_selected_card);
        myCard.setCharacterSelectObject(selected);
        myCard.characterIV.setImageResource(selected.getImageName());
        myCard.charNameTV.setText(selected.getName());
        myCard.charNameTV.setPadding(0,0,0,0);
        myCard.setWeakReference(this);
        myCard.characterNoXContainer.setPadding(10,5,10,0);
        myCard.characterNoXContainer.setBackgroundResource(R.drawable.card_bg_selected);
        myCard.setIsClickable(false);
        myCard.setIsSelected(true);
        myCard.getView().setOnClickListener(myCard.selectedClickListener);
    }

    private void initCards() {
        try {
            CharacterCustomeView card;
            ArrayList<CharacterSelectObject> creationList = Utils.getDataSet();
            Collections.shuffle(creationList);

            String id;
            String name;
            int imageName = -1;
            for (int i = 1; i <= 18; i++) {
                id = "card_" + i;
                int idInteger = getResources().getIdentifier(id, "id", getPackageName());
                card = findViewById(idInteger);
                name = creationList.get(i - 1).getName();
                imageName = creationList.get(i-1).getImageName();
                card.setImageResource(imageName);
                card.setWeakReference(this);
                card.setCharacterSelectObject(creationList.get(i-1));
                card.charNameTV.setText(name);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) card.charNameTV.getLayoutParams();
//                params.setMargins(0, 0, 0, Utils.dpToPx(4));
                card.characterIV.setImageResource(imageName);
                card.characterNoXContainer.setBackgroundResource(R.drawable.card_bg_basic);
//                card.setOnLongClickListener(new longClickListener(name, imageName, this));
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


//    public static class longClickListener implements View.OnLongClickListener{
//
//        String name = "";
//        int resourceImageID = -1;
//        WeakReference<BaseActivity> activityCompatWeakReference;
//
//        public longClickListener(String name, int resourceImageID, BaseActivity activityCompat) {
//            this.name = name;
//            this.resourceImageID = resourceImageID;
//            activityCompatWeakReference = new WeakReference<>(activityCompat);
//        }
//
//        @Override
//        public boolean onLongClick(View v) {
//            EasyGameActivity a = ((EasyGameActivity) activityCompatWeakReference.get());
//            a.openPressenCardDialog(Utils.getContext(),a.selected);
//
//            Toast.makeText(Utils.getContext(), "LLLLOOOOONNNGGGG", Toast.LENGTH_SHORT).show();
//            return true;
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Utils.isMuted()) {
            soundBtn.setImageResource(R.drawable.mute_btn);
            Utils.pauseMusic();
        } else {
            soundBtn.setImageResource(R.drawable.un_mute_btn);
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
