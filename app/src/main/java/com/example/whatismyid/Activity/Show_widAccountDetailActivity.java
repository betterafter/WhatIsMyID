package com.example.whatismyid.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.ShowNameSavedAccountAdapter;

import java.util.ArrayList;

import listDataForm.item_normal;

public class Show_widAccountDetailActivity extends Show_widAccountActivity {

    private ShowNameSavedAccountAdapter adapter;
    private String siteName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_account_detail);

        siteName = getIntent().getStringExtra("detailinfo_sitename");

        recyclerviewInit();
        CurrentActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.ClearAllItem();
        ShowListDetailData();
    }

    // recyclerview 초기화
    private void recyclerviewInit(){

        RecyclerView recyclerView = findViewById(R.id.show_detail);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ShowNameSavedAccountAdapter();
        recyclerView.setAdapter(adapter);
    }



    private void CurrentActionBar(){
        widActionbar bar = new widActionbar(this, getSupportActionBar());
        bar.ShowAccount_ActionbarStyle();
    }


    public void ShowListDetailData(){

        ArrayList<ArrayList<String>> list = databaseHelper.getResultToArrayList();

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).get(1).equals(siteName)) {

                item_normal normal = new item_normal(3);

                normal.setID(list.get(i).get(3));
                normal.setPassword(list.get(i).get(4));
                normal.setEmail(list.get(i).get(5));
                normal.setMemo(list.get(i).get(6));

                adapter.AddItem(normal);
            }
        }
        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
    }


}
