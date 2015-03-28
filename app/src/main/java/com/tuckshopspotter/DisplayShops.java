package com.tuckshopspotter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CodeTribe on 2015-03-28.
 */
public class DisplayShops extends ActionBarActivity{

    ListView listView;
    Context ctx;
    NotificationAdaptor notificationAdaptor;

    TextView txtShop_Name;
    TextView txtInventory_Item;
    TextView txtLatitude;
    TextView txtLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_display);
        txtShop_Name = (TextView) findViewById(R.id.txtShop_Name);
        txtInventory_Item = (TextView) findViewById(R.id.txtInventory);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);


        //recieve Bundle

        Bundle b = this.getIntent().getBundleExtra("shopsBundle");
        //getting data from
        String shopname = b.getString("shopname");
        String inventory = b.getString("inventory");
        String latitude = b.getString("latitude");
        String longitude = b.getString("longitude");

        //set views
        txtShop_Name.setText(shopname);
        txtInventory_Item.setText(inventory);
        txtLongitude.setText(latitude);
        txtLatitude.setText(longitude);


    }

}
