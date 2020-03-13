package com.example.whatismyid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class wid_Database extends AppCompatActivity implements wid_Account {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_account);
    }


    abstract public void SaveToDatabase(String[] strings);
    abstract public void LoadFromDatabase();
    abstract public void ShowListData();


}
