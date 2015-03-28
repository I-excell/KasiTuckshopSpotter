package com.tuckshopspotter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.tuckshopspotter.ShopDTO.ShopDTO;
import com.tuckshopspotter.providers.ShopsContentProviderUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CodeTribe on 2015-03-28.
 */
public class ProcessingList  extends ActionBarActivity {
    Context ctx;
    ListView listView;
    Button btn_registershop;
    NotificationAdaptor notificationAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_display);

        listView = (ListView) findViewById(R.id.shops_listView);
        List<ShopDTO> shopsList = ShopsContentProviderUtils.getShops(getContentResolver());
        if (shopsList == null) {
            shopsList = new ArrayList<>();
        }
        ctx = getApplicationContext();
        notificationAdaptor = new NotificationAdaptor(ctx, shopsList);
        listView.setAdapter(notificationAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShopDTO shopitem = (ShopDTO) notificationAdaptor.getItem(position);

                Intent intent = new Intent(getApplicationContext(), ProcessingList.class);

                Bundle b = new Bundle();
                b.putString("shopname",shopitem.getShopname());
                b.putDouble("latitude", shopitem.getLongitude());
                b.putDouble("longitude",shopitem.getLongitude());
                b.putString("invenatory",shopitem.getInventory());

                intent.putExtra("shopsBundle",b);
                startActivity(intent);
            }
        });
        listView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {




            }
        });
    }
}







