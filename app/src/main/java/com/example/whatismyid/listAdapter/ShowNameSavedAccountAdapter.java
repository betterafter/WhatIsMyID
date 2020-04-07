package com.example.whatismyid.listAdapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.whatismyid.R;

public class ShowNameSavedAccountAdapter extends Adapter {



    @Override
    public void onBindViewHolder(ViewHolder holder, int position){

        holder.DetailBind(item_normals.get(position));
    }

    @Override
    public ShowNameSavedAccountAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.list_detailitem, parent, false) ;
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view) ;

        // detail 버튼 이미지 색 변경
        String buttonColor = "#0080FF";

        final ImageButton EditButton = (ImageButton)view.findViewById(R.id.detailedit);
        EditButton.setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_IN);

        ImageButton DeleteButton = (ImageButton)view.findViewById(R.id.detaildelete);
        DeleteButton.setColorFilter(Color.parseColor(buttonColor), PorterDuff.Mode.SRC_IN);


        ButtonTouch(EditButton);
        ButtonTouch(DeleteButton);


        return vh ;
    }


    void ButtonTouch(final ImageButton button){
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
