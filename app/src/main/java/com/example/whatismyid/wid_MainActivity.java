package com.example.whatismyid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.whatismyid.Activity.wid_databaseHelper;

public abstract class wid_MainActivity extends AppCompatActivity implements wid_Account {

    protected wid_databaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.save_account);
    }


    abstract public void SaveToDatabase(String[] strings);
    abstract public void LoadFromDatabase();
    abstract public void ShowListData();




}
