package com.example.whatismyid.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.whatismyid.R;
import com.example.whatismyid.wid_MainActivity;

public class Save_widAccountActivity extends wid_MainActivity {

    // 각 EditText에 자신의 계정 정보를 입력
    // save 버튼을 누르면 EditText에 적은 text를 가져와 sql 저장
    // 사이트 이름 옆에 있는 버튼을 누르면 이전에 추가했던 사이트 이름들을 전부 가져와서 추천 목록으로 추가 (RecyclerVeiw로 구현)
    // 메모에는 해당 계정에 대한 추가 정보를 마음대로 작성하는 칸.

    // 순서대로 사이트 이름 - 사이트 주소 - 아이디 - 비밀번호 - 이메일 - 추가 메모
    public AppCompatEditText SiteNameText, SiteURLText, LogInText, PasswordText, EmailText, MemoText;
    //private widSQLdataContract widData;
    wid_databaseHelper databaseHelper;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.save_account);
        init();
        CurrentActionBar();

        databaseHelper = new wid_databaseHelper(getApplicationContext(), "wid", null, 1);
    }




    private void CurrentActionBar(){
        widActionbar bar = new widActionbar(this, getSupportActionBar());
        bar.SaveAccount_ActionbarStyle();
    }



    // 각 EditText 선언
    private void init(){

        SiteNameText = findViewById(R.id.tag);
        SiteURLText =  findViewById(R.id.url);
        LogInText = findViewById(R.id.id);
        PasswordText = findViewById(R.id.password);
        EmailText = findViewById(R.id.email);
        MemoText = findViewById(R.id.text);

        SiteNameText.requestFocus();
    }



    // EditText가 focus 해제 되었을 때 키보드 내리기 위한 터치 이벤트
    @Override
    public boolean onTouchEvent (MotionEvent motionEvent){

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if(imm.isAcceptingText()){
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

        return true;
    }



    // EditText에 적은 text들 가져오기
    public String[] GetAccountInformation(){

        String[] account = new String[6];

        account[0] = SiteNameText.getText().toString();
        account[1] = SiteURLText.getText().toString();
        account[2] = LogInText.getText().toString();
        account[3] = PasswordText.getText().toString();
        account[4] = EmailText.getText().toString();
        account[5] = MemoText.getText().toString();

        return account;
    }

    // 사이트 이름 옆에 돋보기 버튼 누르면 이름 추천 팝업창 띄우기
    public void onClickForPopUpActivate(View view){

        Intent intent = new Intent(this, NameSuggestPopupActivity.class);
        startActivityForResult(intent, 1);
    }




    public void SaveToDatabase(String[] strings){

        databaseHelper.insert(strings[0], strings[1], strings[2], strings[3], strings[4], strings[5]);
        //databaseHelper.update();
        //MemoText.setText(databaseHelper.getResult());
        Toast toast = Toast.makeText(this, "저장되었습니다.", Toast.LENGTH_SHORT);
        toast.show();
    }


    public void LoadFromDatabase(){

    }


    public void ShowListData(){}


    public void ShowListNameData(){

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 0){
            SiteNameText.setText(data.getExtras().getString("sitename"));
        }
    }


    public void onSaveButtonClick(View view){
        SaveToDatabase(GetAccountInformation());
    }




}
