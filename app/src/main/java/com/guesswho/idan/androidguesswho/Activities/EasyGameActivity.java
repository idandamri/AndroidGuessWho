package com.guesswho.idan.androidguesswho.Activities;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.guesswho.idan.androidguesswho.CustomSpinnerAdapter;
import com.guesswho.idan.androidguesswho.R;

import java.util.ArrayList;

public class EasyGameActivity extends BaseActivity {

    ArrayList<String> questions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

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

    public  static AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            String item = parent.getItemAtPosition(position).toString();

            Toast.makeText(parent.getContext(), "Android Custom Spinner Example Output..." + item, Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
