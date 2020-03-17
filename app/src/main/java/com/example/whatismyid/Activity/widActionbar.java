package com.example.whatismyid.Activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.whatismyid.R;

public class widActionbar {

    private Activity activity;
    private android.support.v7.app.ActionBar actionBar;

    public widActionbar(Activity activity, android.support.v7.app.ActionBar actionBar){
        this.activity = activity;
        this.actionBar = actionBar;
    }

    public void ShowAccount_ActionbarStyle(){

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.show_actionbar, null);
        actionBar.setCustomView(mCustomView);
    }


    public void SaveAccount_ActionbarStyle(){

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.save_actionbar, null);
        actionBar.setCustomView(mCustomView);
    }
}
