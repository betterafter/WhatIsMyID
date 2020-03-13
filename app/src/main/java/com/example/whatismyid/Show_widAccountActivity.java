package com.example.whatismyid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import listDataForm.item_normal;

public class Show_widAccountActivity extends AppCompatActivity {

    private Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_account);

        init();
        ShowListData();
    }

    // recyclerview 초기화
    private void init(){

        RecyclerView recyclerView = findViewById(R.id.show_account);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }




    private void ShowListData(){

        List<String> SampleTitle = Arrays.asList("구글, 네이버, 다음");
        List<String> SampleIDCount = Arrays.asList("1, 3, 3");

        for(int i = 0; i < SampleTitle.size(); i++){

            item_normal item_normals = new item_normal();
            item_normals.setSiteName(SampleTitle.get(i));
            item_normals.setIDNumber(SampleIDCount.get(i));

            adapter.AddItem(item_normals);
        }
    }

}
