package com.example.whatismyid;

public interface wid_Account {

    // GetAccountInformation의 String 배열을 받아서 database에 저장
    void SaveToDatabase(String[] strings);

    // database에 사이트 이름들을 가져오기
    void LoadSiteNameToDatabase();
}
