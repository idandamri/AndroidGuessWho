package com.guesswho.idan.androidguesswho;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Idan on 05/01/2018.
 */

public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context activity;
    private ArrayList<String> asr;

    public CustomSpinnerAdapter(Context context,ArrayList<String> asr) {
        this.asr=asr;
        activity = context;
    }

    public int getCount()
    {
        return asr.size();
    }

    public Object getItem(int i)
    {
        return asr.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(activity);
        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(18);
        txt.setGravity(Gravity.CENTER_VERTICAL);
        txt.setText(asr.get(position));
        txt.setTextColor(Color.parseColor("#000000"));
        txt.setBackgroundColor(Color.WHITE);
        txt.setGravity(Gravity.CENTER);
//        txt.setPadding(7,20,7,20);
        return  txt;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {

        TextView txt = new TextView(activity);
        txt.setGravity(Gravity.CENTER);
        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(16);
//        txt.setBackgroundResource(R.drawable.custom_spinner_background);
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_drop_up_spinner_arrow, 0);
        txt.setText(asr.get(i));
        txt.setTextColor(Color.parseColor("#000000"));
        return  txt;
    }

}