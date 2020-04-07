package com.example.whatismyid.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
        actionBar.setElevation(0);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.show_actionbar, null);
        actionBar.setCustomView(mCustomView);
    }

    public void ShowDetailAccount_ActionbarStyle(String t){

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setElevation(0);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.show_detail_actionbar, null);
        TextView title = mCustomView.findViewById(R.id.detailtitlebar);
        title.setText(t);
        actionBar.setCustomView(mCustomView);
    }


    public void SaveAccount_ActionbarStyle(){

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setElevation(0);

        View mCustomView = LayoutInflater.from(activity).inflate(R.layout.save_actionbar, null);
        ImageButton backbutton = (ImageButton)mCustomView.findViewById(R.id.backbutton);
        ImageButton savebutton = (ImageButton)mCustomView.findViewById(R.id.savebutton);

        ButtonTouch(backbutton);
        ButtonTouch(savebutton);

        actionBar.setCustomView(mCustomView);
    }



    void ButtonTouch(final ImageButton button){

        String buttonColor = "#0080FF";
        button.setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_IN);

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
    }
}
