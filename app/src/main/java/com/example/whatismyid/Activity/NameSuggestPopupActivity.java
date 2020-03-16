package com.example.whatismyid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.NameSuggestAdapter;

import java.util.Arrays;
import java.util.List;

import listDataForm.item_normal;

public class NameSuggestPopupActivity extends Save_widAccountActivity {

    private NameSuggestAdapter nameSuggestAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_account_popup);

        recyclerviewInit();
        ShowListNameData();
    }

    // 이름 추천 리스트 설정
    public void recyclerviewInit(){
        RecyclerView recyclerView = findViewById(R.id.suggestview);
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


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    // 이름 설정 리스트에 들어갈 데이터들. Show_widAccountActivity 에서 오버라이딩한 것 처럼 만들면 된다.
    // 대상 adapter는 현재 클래스에 있는 recyclerVeiw 의 adapter인 showNameSavedAccountAdapter
    @Override
    public void ShowListNameData(){
        // e.g.
        // 데이터를 저장할 리스트들 (사이트 이름, 사이트 별로 저장된 아이디 개수 저장)
        List<String> SampleTitle = Arrays.asList("구글", "네이버", "다음", "아무거나", "적어보세요", "하하하", "스크롤테스트", "하하하", "하하하");

        // 저장한 데이터를 item_normal 형식으로 바꿔서 adapter에 연결
        // 리사이클러뷰 (리스트뷰)의 한 칸이 한개의 item_normal이 됨.
        // 여러개의 item_normal을 리스트로 출력해서 보여주는 것이라고 생각하면 됨.
        for(int i = 0; i < SampleTitle.size(); i++){

            item_normal item_normals = new item_normal();
            item_normals.setSiteName(SampleTitle.get(i));

            nameSuggestAdapter.AddItem(item_normals);
        }
        nameSuggestAdapter.notifyDataSetChanged();

    }

}
