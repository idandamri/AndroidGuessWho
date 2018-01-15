package com.guesswho.idan.androidguesswho.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.guesswho.idan.androidguesswho.CharSelectorAdapter;
import com.guesswho.idan.androidguesswho.R;

import java.util.ArrayList;

public class CharecterSelectorScreen extends AppCompatActivity {

    private RecyclerView charListRV;
    private RecyclerView.Adapter charRVAdapter;
    private RecyclerView.LayoutManager charRVLayoutManager;
    private ArrayList<String> DataSet;
    private TextView playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charecter_selector_screen);

        initRv();
    }

    private void initRv() {

        DataSet = new ArrayList<>();
        for (int i = 0 ; i < 22 ; i++){
            DataSet.add("Name "+i);
        }
        charListRV = findViewById(R.id.char_selector_recycler_view);
        playBtn = findViewById(R.id.select_card_tv);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivity = new Intent(getApplicationContext(), EasyGameActivity.class);
                startActivity(gameActivity);
            }
        });
        charListRV.setHasFixedSize(true);
        charRVLayoutManager = new LinearLayoutManager(Utils.getContext(),LinearLayoutManager.HORIZONTAL,false);
        charListRV.setLayoutManager(charRVLayoutManager);
        charRVAdapter = new CharSelectorAdapter(DataSet);
        charListRV.setAdapter(charRVAdapter);

    }
}
