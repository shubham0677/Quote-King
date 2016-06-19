package com.sharma.shubham.quoteking;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shubham on 12/31/2015.
 */
public class DatabaseAccess {

    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;


    private DatabaseAccess(Context context)
    {
        this.openHelper=new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database=openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null){
            this.database.close();
        }
    }

    public List<String> getQuotes0(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='mot'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public List<String> getQuotes1(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='suc'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getQuotes2(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='love'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getQuotes3(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='fam'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public List<String> getQuotes4(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='job'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getQuotes5(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='frndship'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


    public List<String> getQuotes6(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='humor'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getQuotes7(){
        List<String> list=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT quote FROM tquotes WHERE key='relation'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }


}
