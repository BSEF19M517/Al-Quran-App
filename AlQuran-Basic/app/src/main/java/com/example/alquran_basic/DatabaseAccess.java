package com.example.alquran_basic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseAccess {
    private final SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return single instance
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //open the database
    public void open(){
        this.db = openHelper.getReadableDatabase();
    }

    //close the database
    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    //return surah info
    public ArrayList<SurahInfo> getSurahInfo(){
        Cursor cursorCourses = db.rawQuery("SELECT SurahID, SurahNameU, SurahNameE, Nazool FROM tsurah",null);
        ArrayList<SurahInfo> surahArrayList = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                surahArrayList.add(new SurahInfo(Integer.parseInt(cursorCourses.getString(0)),
                        cursorCourses.getString(1),cursorCourses.getString(2),cursorCourses.getString(3)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return surahArrayList;
    }

    public ArrayList<ParaInfo> getParaInfo() {
        Cursor cursorCourses = db.rawQuery("SELECT paraID, paraNameU, paraNameE FROM tpara",null);
        ArrayList<ParaInfo> paraArrayList = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                paraArrayList.add(new ParaInfo(Integer.parseInt(cursorCourses.getString(0)),
                        cursorCourses.getString(1),cursorCourses.getString(2)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return paraArrayList;
    }
}
