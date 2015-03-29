package com.tuckshopspotter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tuckshopspotter.ShopDTO.ShopDTO;
import com.tuckshopspotter.providers.ShopsContentProviderUtils;


public class RegisterShop_Activity extends ActionBarActivity {
    TextView txtShop_Name;
    TextView txtInventory_Item;
    TextView txtLatitude;
    TextView txtLongitude;
    Button btn_registershop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_shop);

        btn_registershop = (Button) findViewById(R.id.btn_registershop);
        txtShop_Name = (TextView) findViewById(R.id.txtShop_Name);
        txtInventory_Item = (TextView) findViewById(R.id.txtInventory);
        txtLatitude = (TextView) findViewById(R.id.txtLatitude);
        txtLongitude = (TextView) findViewById(R.id.txtLongitude);

btn_registershop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String shopname = txtShop_Name.getText().toString();
        String inventory = txtInventory_Item.getText().toString();
        String latitude = txtLatitude.getText().toString();
        String longitude = txtLongitude.getText().toString();
        String photourl="";

       // ShopDTO shop = new ShopDTO(0,shopname,inventory,latitude,longitude,photourl,datetaken);
        ShopDTO shopDTO = new ShopDTO(0,shopname, inventory, Double.parseDouble(latitude), Double.parseDouble(longitude),photourl);
            ShopsContentProviderUtils.addShop(getContentResolver(), shopDTO);

    }
});

//        adaptor = new NotificationAdaptor(ctx,mShops);
//        AM_list.setAdapter(adaptor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
