package com.sharma.shubham.quoteking;

import android.content.Context;
import android.provider.ContactsContract;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Shubham on 12/31/2015.
 */
public class DatabaseOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME="Quotes7.s3db";
    private static final int DATABASE_VERSION=1;

    public DatabaseOpenHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
}
