package com.example.whatismyid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.ShowAccountAdapater;

import java.util.Arrays;
import java.util.List;

import listDataForm.item_normal;

public class Show_widAccountActivity extends Save_widAccountActivity {

    private ShowAccountAdapater adapter;

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

        adapter = new ShowAccountAdapater();
        recyclerView.setAdapter(adapter);
    }




    // 데이터베이스에서 사이트 이름, 사이트 별로 저장된 아이디 개수, 해당 사이트에 등록되어 있는 로고를 가져와서
    // List에 넣어서 item_normal 데이터 형식 클래스에 넣어서 adapter에 연결해주면 됨.
    public void ShowListData(){

        // e.g.
        // 데이터를 저장할 리스트들 (사이트 이름, 사이트 별로 저장된 아이디 개수 저장)
        List<String> SampleTitle = Arrays.asList("구글", "네이버", "다음");
        List<String> SampleIDCount = Arrays.asList("1", "3", "3");

        // 저장한 데이터를 item_normal 형식으로 바꿔서 adapter에 연결
        // 리사이클러뷰 (리스트뷰)의 한 칸이 한개의 item_normal이 됨.
        // 여러개의 item_normal을 리스트로 출력해서 보여주는 것이라고 생각하면 됨.
        for(int i = 0; i < SampleTitle.size(); i++){

            item_normal item_normals = new item_normal();
            item_normals.setSiteName(SampleTitle.get(i));
            item_normals.setIDNumber(SampleIDCount.get(i));

            adapter.AddItem(item_normals);
        }
        adapter.notifyDataSetChanged();
    }


    public void onSaveAccountClick(View view){
        Intent intent = new Intent(Show_widAccountActivity.this, Save_widAccountActivity.class);
        startActivity(intent);
    }

}
