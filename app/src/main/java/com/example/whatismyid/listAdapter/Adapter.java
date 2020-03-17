package com.example.whatismyid.listAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.whatismyid.R;

import java.util.ArrayList;

import listDataForm.item_normal;

public abstract class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    protected ArrayList<item_normal> item_normals = new ArrayList<>();

    @Override
    public int getItemCount(){

        return item_normals.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        // ShowAccountAdapter
        public TextView Titleview;
        public TextView idCountview;
        public ImageView Logoview;
        public TextView urlview1;

        // SHowNameSavedAccountAdapter
        public TextView Titleview1;
        public TextView IDview;
        public TextView passwordview;
        public TextView Emailview;
        public TextView memoview;
        public TextView urlview2;

        // NameSuggestAdapter
        public TextView Titleview2;
        public ImageView Logoview2;


        ViewHolder(View itemView) {
            super(itemView);

            // ShowAccountAdapter
            Titleview = itemView.findViewById(R.id.titleview);
            idCountview = itemView.findViewById(R.id.idnumberview);
            Logoview = itemView.findViewById(R.id.logoview);


            // NameSuggestAdapter
            Titleview2 = itemView.findViewById(R.id.namesuggestview);


        }

        void Bind(item_normal item_normal){
            Titleview.setText(item_normal.getSiteName());
            idCountview.setText("저장한 ID : " + item_normal.getIDNumber());
            Logoview.setImageResource(item_normal.getLogo());
        }


        void NameSuggestBind(item_normal item_normal){

            Titleview2.setText(item_normal.getSiteName());
        }
    }



    public void AddItem(item_normal item){
        item_normals.add(item);
    }
}
