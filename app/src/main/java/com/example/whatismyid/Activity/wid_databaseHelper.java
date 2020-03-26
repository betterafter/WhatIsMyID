package com.example.whatismyid.Activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class wid_databaseHelper extends SQLiteOpenHelper {

    // DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public wid_databaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // DB를 새로 생성할 때 호출되는 함수
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블 생성
        /* 이름은 wid이고, 자동으로 값이 증가하는 _id 정수형 기본키 컬럼과
        item 문자열 컬럼, price 정수형 컬럼, create_at 문자열 컬럼으로 구성된 테이블을 생성. */
        db.execSQL("CREATE TABLE wid (_id INTEGER PRIMARY KEY AUTOINCREMENT, sitename TEXT, " +
                "siteurl TEXT, id TEXT, password TEXT, email TEXT, memo TEXT);");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(String sitename, String siteurl, String id, String password, String email, String memo) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO wid VALUES(null, '" + sitename + "', '" + siteurl + "', '" + id + "', '" + password + "', '" + email + "', '" + memo + "');");
        db.close();
    }

    public void update() {
        SQLiteDatabase db = getWritableDatabase();
        db.rawQuery("SELECT * FROM wid ORDER BY sitename ASC", null);
        db.close();
    }

    public void delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        // 입력한 항목과 일치하는 행 삭제
        db.execSQL("DELETE FROM wid WHERE id='" + id + "';");
        db.close();
    }


    public String[] getResultToStringArray(int idx){
        SQLiteDatabase db = getReadableDatabase();
        String result[] = new String[7];
        //boolean isResultExist = false;

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM wid ORDER BY sitename DESC", null);

        while(cursor.moveToNext()){
            if(cursor.getString(0) == Integer.toString(idx)){
                //isResultExist = true;
                for(int i = 0; i < 7; i++){
                    result[i] = cursor.getString(i);
                }

                break;
            }
        }

        return result;
    }



    public ArrayList<ArrayList<String> > getResultToArrayList(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<ArrayList<String> > result = new ArrayList<>();

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM wid ORDER BY sitename ASC", null);

        while(cursor.moveToNext()){

            ArrayList<String> inner = new ArrayList<>();
            for(int i = 0; i < 7; i++){
                inner.add(cursor.getString(i));
            }

            result.add(inner);
        }

        return result;
    }



    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM wid", null);
        while (cursor.moveToNext()) {
            result += "테이블 번호 : "
                    + cursor.getString(0)
                    + "          사이트 이름 : "
                    + cursor.getString(1)
                    + "          사이트 주소 : "
                    + cursor.getString(2)
                    + "          아이디 : "
                    + cursor.getString(3)
                    + "          암호 : "
                    + cursor.getString(4)
                    + "          이메일 : "
                    + cursor.getString(5)
                    + "          메모 : "
                    + cursor.getString(6)
                    + "\n";
        }

        return result;
    }
}
