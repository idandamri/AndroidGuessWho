package com.guesswho.idan.androidguesswho.Activities;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.guesswho.idan.androidguesswho.CharacterCustomeView;
import com.guesswho.idan.androidguesswho.CharacterSelectObject;
import com.guesswho.idan.androidguesswho.CustomSpinnerAdapter;
import com.guesswho.idan.androidguesswho.R;

import java.util.ArrayList;

public class EasyGameActivity extends BaseActivity {

    ArrayList<String> questions = new ArrayList<String>();
    CharacterSelectObject selected;

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
        Spinner spinner = findViewById(R.id.quest_spinner);
        // Spinner Drop down elements
        createSpinnerElements();

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(this.getApplicationContext(), questions);
        spinner.setAdapter(customSpinnerAdapter);
        spinner.setOnItemSelectedListener(spinnerListener);

        CharacterCustomeView myCard = findViewById(R.id.my_selected_card);
        myCard.characterIV.setImageResource(selected.getImageName());
        myCard.charNameTV.setText(selected.getName());

        myCard.setIsClickable(false);
        myCard.getView().setOnClickListener(mySelectionCardListener);
//        myCard.setOnClickListener(mySelectionCardListener);
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
                CharacterCustomeView characterCustomeView =  newView.findViewById(R.id.my_selected_dialog_card);
                TextView characterCustomeViewTitle =  newView.findViewById(R.id.my_choice_card);
                characterCustomeViewTitle.setText(R.string.my_choice);
                characterCustomeView.setIVResource(selected.getImageName());
                characterCustomeView.setIsClickable(false);
                characterCustomeView.setCharecterName(selected.getName());
                settingsDialog.setContentView(newView);

                characterCustomeView.setSoundEffectsEnabled(false);
                settingsDialog.show();
        }
    };
}
