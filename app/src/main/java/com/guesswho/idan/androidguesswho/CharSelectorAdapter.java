package com.guesswho.idan.androidguesswho;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guesswho.idan.androidguesswho.Activities.Utils;

import java.util.ArrayList;

/**
 * Created by Idan on 15/01/2018.
 */

public class CharSelectorAdapter extends RecyclerView.Adapter<CharSelectorAdapter.ViewHolder> {

    private ArrayList<String> DataSet;

    public CharSelectorAdapter(ArrayList<String> dataSet) {
        DataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Utils.getContext()).inflate(R.layout.card_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardCharacterCustomeView.setCharecterName(DataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CharacterCustomeView cardCharacterCustomeView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardCharacterCustomeView = itemView.findViewById(R.id.char_item_in_selector);
        }
    }
}
