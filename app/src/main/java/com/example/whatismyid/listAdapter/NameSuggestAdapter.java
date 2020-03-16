package com.example.whatismyid.listAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatismyid.R;

public class NameSuggestAdapter extends Adapter {

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.NameSuggestBind(item_normals.get(position));
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.list_nameitem, parent, false) ;
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view) ;


        return vh ;
    }
}
