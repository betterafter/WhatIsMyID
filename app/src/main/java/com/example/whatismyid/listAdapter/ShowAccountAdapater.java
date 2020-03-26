package com.example.whatismyid.listAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.whatismyid.R;

public class ShowAccountAdapater extends Adapter {

    final static int SHOWSITENAME_TYPE = 1;
    final static int ALPHABETORDER_TYPE = 2;
    final static int SHOWACCOUNTLIST_TYPE = 3;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        if(item_normals.get(position).getType() == 2){
            holder.NameSuggestBind(item_normals.get(position));
        }
        else {
            holder.Bind(item_normals.get(position));
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        if(viewType == ALPHABETORDER_TYPE){
            View view2 = inflater.inflate(R.layout.list_baseitem, parent, false);
            Adapter.ViewHolder vh = new Adapter.ViewHolder(view2) ;
            return vh ;
        }

        else {
            View view = inflater.inflate(R.layout.list_normalitem, parent, false) ;
            Adapter.ViewHolder vh = new Adapter.ViewHolder(view) ;
            return vh ;
        }
    }
}
