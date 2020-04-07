package com.example.whatismyid.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.ShowAccountAdapater;

import java.util.ArrayList;

import listDataForm.item_normal;

public class Show_widAccountActivity extends Save_widAccountActivity {

    private ShowAccountAdapater adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_account);

        recyclerviewInit();
        ShowListData();
        CurrentActionBar();
        SearchViewClick();

        // 계정 생성 버튼 맨 위로 올리기
        String buttonColor = "#0080FF";

        ImageButton newAccountbutton = findViewById(R.id.newAccount);
        newAccountbutton.setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_IN);
        newAccountbutton.bringToFront();
    }



    @Override
    protected void onResume() {
        super.onResume();

        adapter.ClearAllItem();
        ShowListData();
    }



    // recyclerview 초기화
    private void recyclerviewInit(){

        RecyclerView recyclerView = findViewById(R.id.show_account);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ShowAccountAdapater();
        recyclerView.setAdapter(adapter);

        //InsertOrderListItem(adapter);
    }


    public void InsertOrderListItem(ShowAccountAdapater adapter){

        String[] kor = { "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ",
                "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ" };

        String[] eng = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z" };

        for(int i = 0; i < kor.length; i++){

            item_normal normal = new item_normal(2);
            normal.setSiteName(kor[i]);
            adapter.AddItem(normal);
        }

        for(int i = 0; i < eng.length; i++){

            item_normal normal = new item_normal(2);
            normal.setSiteName(eng[i]);
            adapter.AddItem(normal);
        }
    }



    private void CurrentActionBar(){
        widActionbar bar = new widActionbar(this, getSupportActionBar());
        bar.ShowAccount_ActionbarStyle();
    }





    // 데이터베이스에서 사이트 이름, 사이트 별로 저장된 아이디 개수, 해당 사이트에 등록되어 있는 로고를 가져와서
    // List에 넣어서 item_normal 데이터 형식 클래스에 넣어서 adapter에 연결해주면 됨.
    @Override
    public void ShowListData(){

        ArrayList<ArrayList<String> > list = databaseHelper.getResultToArrayList();
        ArrayList<String> isShown = new ArrayList<>();


        for(int i = 0; i < list.size(); i++){

            if(!isShown.contains(list.get(i).get(1))){
                item_normal normal = new item_normal(3);
                normal.setSiteName(list.get(i).get(1));

                isShown.add(list.get(i).get(1));
                adapter.AddItem(normal);
            }
        }

        adapter.SortAllItem();
        adapter.notifyDataSetChanged();
    }





    public void ShowSearchedListData(String newText){

        ArrayList<ArrayList<String> > list = databaseHelper.getResultToArrayList();
        ArrayList<String> isShown = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).get(1).contains(newText) && !isShown.contains(list.get(i).get(1))){
                item_normal normal = new item_normal(3);
                normal.setSiteName(list.get(i).get(1));

                isShown.add(list.get(i).get(1));
                adapter.AddItem(normal);
            }
        }

        adapter.SortAllItem();
        adapter.notifyDataSetChanged();
    }



    // 새로운 계정 저장하기 버튼 클릭
    public void onSaveAccountClick(View view){

        final ImageButton button = (ImageButton)view;
        button.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                String buttonColor = "#0080FF";

                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN : {
                        button.setColorFilter(Color.parseColor("#81BEF7"), PorterDuff.Mode.SRC_IN);
                        break;
                    }
                    case MotionEvent.ACTION_UP   : {
                        button.setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_IN);
                        break;
                    }
                }
                return false;
            }
        });


        Intent intent = new Intent(Show_widAccountActivity.this, Save_widAccountActivity.class);
        intent.putExtra("StartActivityType", "new");
        startActivity(intent);
    }




    // 화면을 전환하여 해당 사이트 이름에 대한 저장한 계정 전부 출력
    public void onShowListClick(View view){

        LinearLayout layout = (LinearLayout)view;
        TextView tv = (TextView)layout.getChildAt(0);
        String text = tv.getText().toString();

        Intent intent = new Intent(Show_widAccountActivity.this, Show_widAccountDetailActivity.class);
        intent.putExtra("detailinfo_sitename", text);
        startActivity(intent);
    }




    public void SearchViewClick(){

        searchView = (SearchView)findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                recyclerviewInit();
                ShowSearchedListData(newText);
                return true;
            }
        });
    }




}
