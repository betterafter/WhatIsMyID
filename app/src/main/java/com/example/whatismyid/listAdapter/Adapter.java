package com.example.whatismyid.listAdapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.whatismyid.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import listDataForm.item_normal;

public abstract class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    protected ArrayList<item_normal> item_normals = new ArrayList<>();

    @Override
    public int getItemCount(){

        return item_normals.size();
    }


    @Override
    public int getItemViewType(int position) {

        return item_normals.get(position).getType();
    }



    class ViewHolder extends RecyclerView.ViewHolder{

        // ShowAccountAdapter
        public TextView Titleview;

        // SHowNameSavedAccountAdapter
        public TextView IDview;
        public TextView passwordview;
        public TextView Emailview;
        public TextView memoview;
        public TextView urlview2;

        // NameSuggestAdapter
        public TextView Titleview2;


        ViewHolder(View itemView) {
            super(itemView);

            // ShowAccountAdapter
            Titleview = itemView.findViewById(R.id.titleview);



            // ShowNameSavedAccountAdapter
            IDview = itemView.findViewById(R.id.detailid);
            passwordview = itemView.findViewById(R.id.detailpassword);
            Emailview = itemView.findViewById(R.id.detailemail);
            memoview = itemView.findViewById(R.id.detailmemo);
            urlview2 = itemView.findViewById(R.id.detailurl);


            // NameSuggestAdapter
            Titleview2 = itemView.findViewById(R.id.namesuggestview);


        }

        void Bind(item_normal item_normal){
            Titleview.setText(item_normal.getSiteName());
        }


        void NameSuggestBind(item_normal item_normal){

            Titleview2.setText(item_normal.getSiteName());
        }


        void DetailBind(item_normal item_normal){

            IDview.setText(item_normal.getID());
            passwordview.setText(item_normal.getPassword());
            Emailview.setText(item_normal.getEmail());
            memoview.setText(item_normal.getMemo());
            urlview2.setText(item_normal.getUrl());
        }
    }



    public void AddItem(item_normal item){

        item_normals.add(item);
        //Collections.sort(item_normals, new AscendingSortString());
    }


    public void ClearAllItem(){

        int size = item_normals.size();
        item_normals.clear();
        notifyItemRangeRemoved(0, size);
    }


    public void SortAllItem(){

        if(item_normals.size() > 0)
            Collections.sort(item_normals, new AscendingSortString());
    }



    class AscendingSortString implements Comparator<item_normal>{

        @Override
        public int compare(item_normal a, item_normal b){

            return a.getSiteName().compareTo(b.getSiteName());
        }
    }
}
