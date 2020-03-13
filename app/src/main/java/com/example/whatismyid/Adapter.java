package com.example.whatismyid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import listDataForm.item_name;
import listDataForm.item_normal;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<item_normal> item_normals = new ArrayList<>();
    private ArrayList<item_name> item_names = new ArrayList<>();

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.Bind(item_normals.get(position));
    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.show_account, parent, false) ;
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view) ;


        return vh ;
    }


    @Override
    public int getItemCount(){

        return item_normals.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Titleview;
        private TextView idCountview;
        private ImageView Logoview;

        ViewHolder(View itemView) {
            super(itemView);

            Titleview = itemView.findViewById(R.id.titleview);
            idCountview = itemView.findViewById(R.id.idnumberview);
            Logoview = itemView.findViewById(R.id.logoview);
        }

        void Bind(item_normal item_all){
            Titleview.setText(item_all.getSiteName());
            idCountview.setText("저장한 ID : " + item_all.getIDNumber());
            Logoview.setImageResource(item_all.getLogo());
        }

    }


    class name_ViewHolder extends RecyclerView.ViewHolder{

        private TextView Titleview;

        name_ViewHolder(View itemView){
            super(itemView);

            Titleview = itemView.findViewById(R.id.list_name);
        }

        void Bind(item_normal item_normal){
            Titleview.setText(item_normal.getSiteName());
        }

    }


    public void AddItem(item_normal item_all){
        item_normals.add(item_all);
    }
}
