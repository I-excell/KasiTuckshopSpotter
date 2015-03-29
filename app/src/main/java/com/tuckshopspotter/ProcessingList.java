package com.tuckshopspotter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by CodeTribe on 2015-03-28.
 */
public class ProcessingList  extends ActionBarActivity {
        TextView txtShop_Name;
        TextView txtInventory_Item;
        TextView txtLatitude;
        TextView txtLongitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.processing_list_layout);

        txtShop_Name = (TextView) findViewById(R.id.txtShop_Name);
        txtInventory_Item =(TextView) findViewById(R.id.txtInventory);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);

        //**receving bundles**//
        Bundle b = this.getIntent().getBundleExtra("shopsBundle");

        //**getting fields**//
        String shopname = b.getString("shopname");
        String inventory = b.getString("inventory");
        String latitude = b.getString("latitude");
        String longitude = b.getString("longitude");

        //**setting fields**//
        txtShop_Name.setText(shopname);
        txtInventory_Item.setText(inventory);
        txtLatitude.setText(latitude);
        txtLongitude.setText(longitude);

    }

}







