package com.tuckshopspotter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tuckshopspotter.ShopDTO.ShopDTO;
import com.tuckshopspotter.providers.ShopsContentProviderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe on 2015-03-28.
 */
public class DisplayShops extends ActionBarActivity{
    ListView listView;
    Context ctx;
    NotificationAdaptor notificationAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_display);

        listView = (ListView) findViewById(R.id.shops_listView);
        List<ShopDTO> shopList = ShopsContentProviderUtils.getShops(getContentResolver());
        if (shopList == null) {
            shopList = new ArrayList<>();
        }
         ctx = getApplicationContext();
        notificationAdaptor = new NotificationAdaptor (ctx,shopList);
        listView.setAdapter(notificationAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShopDTO shopLitsItem = (ShopDTO) notificationAdaptor.getItem(position);

                Intent intent = new Intent(getApplicationContext(),ProcessingList.class);

                Bundle b = new Bundle();
                b.putString("shopname",shopLitsItem.getShopname());
                b.putString("inventory", shopLitsItem.getInventory());
                b.getDouble("longitude", shopLitsItem.getLongitude());
                b.getDouble("latitude", shopLitsItem.getLatitude());
                intent.putExtra("shopsBundle",b);
                startActivity(intent);
            }
        });



    }

}
