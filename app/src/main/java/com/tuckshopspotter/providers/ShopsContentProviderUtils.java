package com.tuckshopspotter.providers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import com.tuckshopspotter.ShopDTO.ShopDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe on 2015-03-15.
 */
public class ShopsContentProviderUtils  {
     private static final String TAG = ShopsContentProviderUtils.class.getSimpleName();

    public static final String SHOPS_AUTHORITY = "com.tuckshopspotter.providers";
    public static final String SHOPS_BASE_PATH = "shops";
    public static final Uri SHOPS_CONTENT_URI = Uri.parse("content://"+SHOPS_AUTHORITY+"/"+SHOPS_BASE_PATH);

    //****These are literal values for Content-Resolver Query Types****
    public static final int QUERY_TYPE_BY_COLUMN_ID = 1;
    public static final int QUERY_TYPE_BY_SHOP_ID = 2;
    public static final int QUERY_TYPE_LIST = 3;

    //******Getting List Of Shops******
    public static List<ShopDTO> getShops(ContentResolver contentResolver){
        List<ShopDTO> shops = new ArrayList<ShopDTO>();
        Cursor shopsListCursor = contentResolver.query(SHOPS_CONTENT_URI,TuckShopTable.DEFAULT_SHOPS_PROJECTIONS,null,null,TuckShopTable.DEFAULT_SORT_ORDER);
        if(shopsListCursor != null){
            //we got the data...now iterate
            while(shopsListCursor.moveToNext()){
                //get the values from the cursor
                ShopDTO shopDTO = fromCursor(shopsListCursor);
                shops.add(shopDTO);
            }
        }

        return shops;
    }

//****Adding to Shops****
public static Uri addShop(ContentResolver contentResolver, ShopDTO shopDataObject){
    Log.i(TAG, "Adding Shop:: \n " + shopDataObject);
    Uri newShopUri = null;
    ContentValues newShopValues = fromShopDTO(shopDataObject);
     if(newShopValues != null){
        newShopUri = contentResolver.insert(SHOPS_CONTENT_URI,newShopValues);
     }
    return newShopUri;
}

//****get Shops From Cursor****
    private static ShopDTO fromCursor( final Cursor cursor){
        if(cursor == null){ return null;}
        String shopname = cursor.getString(cursor.getColumnIndex(TuckShopTable.COLUMN_SHOP_NAME));
        String inventory = cursor.getString(cursor.getColumnIndex(TuckShopTable.COLUMN_INVENTORY));
        Double latitude = cursor.getDouble(cursor.getColumnIndex(TuckShopTable.COLUMN_LATITUDE));
        Double longitude = cursor.getDouble(cursor.getColumnIndex(TuckShopTable.COLUMN_lONGITUDE));
        String photourl = cursor.getString(cursor.getColumnIndex(TuckShopTable.COLUMN_PHOTOURL));
        String datetaken = cursor.getString(cursor.getColumnIndex(TuckShopTable.COLUMN_DATE));


        int shopID = cursor.getInt(cursor.getColumnIndex(TuckShopTable.COLUMN_SHOP_ID));
       int id = cursor.getInt(cursor.getColumnIndex(TuckShopTable.COLUMN_CP_SHOP_ID));
        ShopDTO shop = new ShopDTO(0,shopname,inventory,latitude,longitude,photourl);

        return shop;
    }
//****Get value to be inserted*****
    public static ContentValues fromShopDTO(ShopDTO shopDataObject){
        if (shopDataObject==null){ return null;}

        ContentValues valuesToInsert = new ContentValues();
        //valuesToInsert.put(TuckShopTable.COLUMN_SHOP_ID, shopDataObject.getShopID());
        valuesToInsert.put(TuckShopTable.COLUMN_SHOP_NAME, shopDataObject.getShopname());
        valuesToInsert.put(TuckShopTable.COLUMN_INVENTORY, shopDataObject.getInventory());
        valuesToInsert.put(TuckShopTable.COLUMN_LATITUDE, shopDataObject.getLatitude());
        valuesToInsert.put(TuckShopTable.COLUMN_lONGITUDE, shopDataObject.getLongitude());


        return valuesToInsert;
    }

}
