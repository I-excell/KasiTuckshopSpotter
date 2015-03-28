package com.tuckshopspotter.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CodeTribe on 2015-03-15.
 */
public class ShopsDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "shopdb.db";
    private static final int Version = 1;

    public ShopsDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, Version);
    }
    @Override
    public void onCreate(SQLiteDatabase database){
        TuckShopTable.onCreate(database);
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i2){
        TuckShopTable.onUpgrade(database);
    }
}
