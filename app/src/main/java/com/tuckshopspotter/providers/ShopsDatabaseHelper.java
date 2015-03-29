package com.tuckshopspotter.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CodeTribe on 2015-03-15.
 */
public class ShopsDatabaseHelper extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String DATABASE_FILE ="shop.db";



    public ShopsDatabaseHelper(Context context) {
        super(context, DATABASE_FILE, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TuckShopTable.onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        TuckShopTable.onUpgrade(db);

    }
}
