package com.guesswho.idan.androidguesswho;

import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guesswho.idan.androidguesswho.Activities.CharecterSelectorScreen;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * Created by Idan on 15/01/2018.
 */

public class CharSelectorAdapter extends RecyclerView.Adapter<CharSelectorAdapter.ViewHolder> {

    private int selectedPos = RecyclerView.NO_POSITION;
    private ArrayList<CharacterSelectObject> DataSet;
    WeakReference selectorScreen;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(Utils.getContext()).inflate(R.layout.card_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(v, (CharecterSelectorScreen) selectorScreen.get());

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        holder.itemView.setSelected(selectedPos == position);
        if (selectedPos != position) {
            holder.itemView.setSelected(false);
        }
        else{
            holder.itemView.setSelected(true);
        }
        holder.charNameTV.setText(DataSet.get(position).getName());
        holder.charIV.setImageResource(DataSet.get(position).getImageName());
//        holder.charIV.setImageResource(DataSet.get(position).getResourceId());
    }

    @Override
    public int getItemCount() {
        return DataSet.size();
    }


    public CharSelectorAdapter(ArrayList<CharacterSelectObject> dataSet, CharecterSelectorScreen charecterSelectorScreen) {
        DataSet = dataSet;
        selectorScreen = new WeakReference(charecterSelectorScreen);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView charIV;
        public TextView charNameTV;
        public LinearLayout container;
        WeakReference<CharecterSelectorScreen> weakReferenceSelectorScreen;

        public ViewHolder(View itemView, CharecterSelectorScreen charecterSelectorScreen) {
            super(itemView);
            charIV = itemView.findViewById(R.id.character_item_iv);
            charNameTV = itemView.findViewById(R.id.character_name);
            container = itemView.findViewById(R.id.character_container);
            container.setOnClickListener(this);
            weakReferenceSelectorScreen = new WeakReference<>(charecterSelectorScreen);
            charNameTV.setTypeface(Utils.getAppTypeFace());
        }

        @Override
        public void onClick(View view) {
            ((RelativeLayout)view.getParent()).setSelected(true);
            notifyItemChanged(selectedPos);
            selectedPos = getAdapterPosition();
            notifyItemChanged(selectedPos);
            weakReferenceSelectorScreen.get().setSelectedCard(DataSet.get(getAdapterPosition()));
        }
    }
}
