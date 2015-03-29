package com.tuckshopspotter.providers;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by CodeTribe on 2015-03-14.
 */
public class TuckShopTable {

    public static final String SHOP_TABLE_NAME = "shops";
    public static final String COLUMN_SHOP_NAME = "shopname";
    public static final String COLUMN_INVENTORY = "inventory";
    public static final String COLUMN_LATITUDE ="latitude";
    public static final String COLUMN_lONGITUDE ="longitude";
    public static final String COLUMN_PHOTOURL ="photourl";
    public static final String COLUMN_DATE ="datetaken";


    public static final String COLUMN_SHOP_ID ="shopid";//Global
    public static final String COLUMN_CP_SHOP_ID ="_ID";//Local

    public static final String DEFAULT_SORT_ORDER = "_ID Desc";

    public static final String[] DEFAULT_SHOPS_PROJECTIONS = {COLUMN_SHOP_NAME, COLUMN_INVENTORY, COLUMN_LATITUDE,COLUMN_lONGITUDE, COLUMN_PHOTOURL,COLUMN_DATE,COLUMN_SHOP_ID};



    private static final String CREATE_TABLE_QUERY = " CREATE TABLE "+SHOP_TABLE_NAME+
            " ( "+COLUMN_CP_SHOP_ID+" integer primary key autoincrement,"
            +COLUMN_SHOP_ID+ " text,"
            +COLUMN_SHOP_NAME+"text not null, "
            +COLUMN_INVENTORY+"text not null, "
            +COLUMN_LATITUDE+ "double not null, "
            +COLUMN_lONGITUDE+"double not null, "
            +COLUMN_PHOTOURL+"text, "
            +COLUMN_DATE+"default)";



    private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+SHOP_TABLE_NAME;


    public static void onCreate(SQLiteDatabase database){
        //create a database/table
        database.execSQL(CREATE_TABLE_QUERY);
    }

    public static void onUpgrade(SQLiteDatabase database){
        //update the database/table
        database.execSQL(DROP_TABLE_QUERY);
        onCreate(database);
    }





}
