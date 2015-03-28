package com.tuckshopspotter.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by CodeTribe on 2015-03-14.
 */
public class ShopsContentProviders extends ContentProvider {
    private static final String TAG = ShopsContentProviders.class.getSimpleName();
    private ShopsDatabaseHelper databaseHelper;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        static {
            //content://com.tuckshopspotter.providers
            uriMatcher.addURI(ShopsContentProviderUtils.SHOPS_AUTHORITY, ShopsContentProviderUtils.SHOPS_BASE_PATH, ShopsContentProviderUtils.QUERY_TYPE_LIST);
            uriMatcher.addURI(ShopsContentProviderUtils.SHOPS_AUTHORITY, ShopsContentProviderUtils.SHOPS_BASE_PATH+"/#", ShopsContentProviderUtils.QUERY_TYPE_BY_COLUMN_ID);
            uriMatcher.addURI(ShopsContentProviderUtils.SHOPS_AUTHORITY, ShopsContentProviderUtils.SHOPS_BASE_PATH+"/shopID/*", ShopsContentProviderUtils.QUERY_TYPE_BY_SHOP_ID);
        }


    @Override
    public boolean onCreate() {
        //initiate the DB
        databaseHelper = new ShopsDatabaseHelper(getContext());
        return false;
    }
    //CRUD
    @Override
    public Cursor query(Uri uri, String[] columnsToReturn, String selection, String[] arguments, String sortOrder) {
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(TuckShopTable.SHOP_TABLE_NAME);
        //is this a query-by ID or by Global-TuckShop-ID?
        int queryType = uriMatcher.match(uri);
        switch(queryType){
            case ShopsContentProviderUtils.QUERY_TYPE_LIST:
                //here the user is retrieving all - i.e select * from shop-s
                break;
            case ShopsContentProviderUtils.QUERY_TYPE_BY_COLUMN_ID:
                //here user is retrieving specific Shop - select * from shops where ID=x
                queryBuilder.appendWhere(TuckShopTable.COLUMN_CP_SHOP_ID+"="+uri.getLastPathSegment());
                break;
            case ShopsContentProviderUtils.QUERY_TYPE_BY_SHOP_ID:
                //here the user is retrieving a vendor with specific global ID
                queryBuilder.appendWhere(TuckShopTable.COLUMN_CP_SHOP_ID+"="+uri.getLastPathSegment());
                break;
            default:
                break;
        }
        Cursor cursor = null;
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        try{
            cursor = queryBuilder.query(db,columnsToReturn,selection,arguments,null,null,TuckShopTable.DEFAULT_SORT_ORDER);
            if(cursor != null){ cursor.setNotificationUri(getContext().getContentResolver(), uri);}

        }catch(Exception e){
            Log.e(TAG, "Error while retrieving Shop(s) ", e);
        }

        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        int queryType = uriMatcher.match(uri);
        if(queryType != ShopsContentProviderUtils.QUERY_TYPE_LIST){
            throw new IllegalArgumentException("Invalid URI pattern for Insert Operation.");
        }

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        long newShopID = db.insert(TuckShopTable.SHOP_TABLE_NAME, null, contentValues);

        getContext().getContentResolver().notifyChange(uri, null);
        Uri newShopURI = Uri.parse(ShopsContentProviderUtils.SHOPS_CONTENT_URI.toString()+"/"+ newShopID);
        Toast.makeText(getContext(), "Shop URI:: " + newShopURI.toString(), Toast.LENGTH_LONG).show();
        return newShopURI;
    }


    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
