package com.example.whatismyid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.NameSuggestAdapter;

import java.util.ArrayList;

import listDataForm.item_normal;

public class NameSuggestPopupActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NameSuggestAdapter nameSuggestAdapter;
    private String siteName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat_Dialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.save_account_popup);

        recyclerviewInit();
        ShowListNameData();
    }




    // 이름 추천 리스트 설정
    public void recyclerviewInit(){
        recyclerView = findViewById(R.id.suggestview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        nameSuggestAdapter = new NameSuggestAdapter();
        recyclerView.setAdapter(nameSuggestAdapter);
    }


    // 팝업창 닫기
    public void onClickForPopUpDeactivate(View view){

        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    // 이름 설정 리스트에 들어갈 데이터들. Show_widAccountActivity 에서 오버라이딩한 것 처럼 만들면 된다.
    // 대상 adapter는 현재 클래스에 있는 recyclerVeiw 의 adapter인 showNameSavedAccountAdapter

    public void ShowListNameData(){
//
        Intent intent = getIntent();
        ArrayList<ArrayList<String>> li = (ArrayList<ArrayList<String>>) intent.getSerializableExtra("database");
        ArrayList<String> isShown = new ArrayList<>();

        for(int i = 0; i < li.size(); i++){

            if(!isShown.contains(li.get(i).get(1))){
                item_normal normal = new item_normal(3);
                normal.setSiteName(li.get(i).get(1));

                isShown.add(li.get(i).get(1));
                nameSuggestAdapter.AddItem(normal);
            }
        }

        nameSuggestAdapter.SortAllItem();
        nameSuggestAdapter.notifyDataSetChanged();
    }







    public void onListItemClick(View view){

        siteName = ((TextView)view).getText().toString();

        Intent intent = new Intent(this, Save_widAccountActivity.class);
        intent.putExtra("sitename", siteName);
        setResult(0, intent);
        finish();
    }





}
