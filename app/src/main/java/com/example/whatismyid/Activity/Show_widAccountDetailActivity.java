package com.example.whatismyid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.whatismyid.R;
import com.example.whatismyid.listAdapter.ShowNameSavedAccountAdapter;

import java.util.ArrayList;

import listDataForm.item_normal;

public class Show_widAccountDetailActivity extends Show_widAccountActivity {

    private ShowNameSavedAccountAdapter adapter;
    private String siteName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_account_detail);

        siteName = getIntent().getStringExtra("detailinfo_sitename");

        recyclerviewInit();
        CurrentActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.ClearAllItem();
        ShowListDetailData();
    }



    // recyclerview 초기화
    private void recyclerviewInit(){

        RecyclerView recyclerView = findViewById(R.id.show_detail);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ShowNameSavedAccountAdapter();
        recyclerView.setAdapter(adapter);
    }



    private void CurrentActionBar(){
        widActionbar bar = new widActionbar(this, getSupportActionBar());
        bar.ShowDetailAccount_ActionbarStyle(siteName);
    }



    public void ShowListDetailData(){

        ArrayList<ArrayList<String>> list = databaseHelper.getResultToArrayList();
        boolean isSiteExistInDatabase = false;

        for(int i = 0; i < list.size(); i++){

            if(list.get(i).get(1).equals(siteName)) {

                isSiteExistInDatabase = true;

                item_normal normal = new item_normal(3);

                normal.setUrl(list.get(i).get(2));
                normal.setID(list.get(i).get(3));
                normal.setPassword(list.get(i).get(4));
                normal.setEmail(list.get(i).get(5));
                normal.setMemo(list.get(i).get(6));

                adapter.AddItem(normal);
            }
        }

        if(!isSiteExistInDatabase){
            Intent intent = new Intent(this, Show_widAccountActivity.class);
            startActivity(intent);
        }

        if(adapter != null){
            adapter.notifyDataSetChanged();
        }
    }



    public void onEditClick(View view){

        View parentView = (View)view.getParent().getParent();

        String url = ((TextView)parentView.findViewById(R.id.detailurl)).getText().toString();
        String id = ((TextView)parentView.findViewById(R.id.detailid)).getText().toString();
        String password = ((TextView)parentView.findViewById(R.id.detailpassword)).getText().toString();
        String email = ((TextView)parentView.findViewById(R.id.detailemail)).getText().toString();
        String memo = ((TextView)parentView.findViewById(R.id.detailmemo)).getText().toString();

        Intent intent = new Intent(this, Save_widAccountActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("id", id);
        intent.putExtra("password", password);
        intent.putExtra("email", email);
        intent.putExtra("memo", memo);
        intent.putExtra("sitename", siteName);

        intent.putExtra("StartActivityType", "edit");

        startActivity(intent);
    }



    public void onDeleteClick(View view){

        View parentView = (View)view.getParent().getParent();

        String id = ((TextView)parentView.findViewById(R.id.detailid)).getText().toString();

        databaseHelper.delete(siteName, id);

        Toast toast = Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT);
        toast.show();

        System.out.println(databaseHelper.getResult());

        adapter.ClearAllItem();
        ShowListDetailData();
    }
}
