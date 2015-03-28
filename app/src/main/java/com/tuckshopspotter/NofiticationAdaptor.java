package com.tuckshopspotter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tuckshopspotter.ShopDTO.ShopDTO;

import java.util.List;

/**
 * Created by CodeTribe on 2015-03-15.
 */
class NotificationAdaptor extends BaseAdapter{
    Context mCtx;
    List<ShopDTO> shopList;

    public NotificationAdaptor(Context mCtx, List<ShopDTO> shops){
        this.mCtx = mCtx;
        this.shopList = shops;
    }

    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int position) {
        return shopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        holder h;
        //code to recycle the views
        if(convertView ==null){
            h = new holder();
            LayoutInflater inflater = (LayoutInflater) mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            h.txtShopName = (TextView) convertView.findViewById(R.id.I_message);
            convertView.setTag(h);
        }else{
            h = (holder) convertView.getTag();
        }
        ShopDTO shop = shopList.get(position);
        h.txtShopName.setText(shop.getShopname());
        return convertView;
    }

    class holder{
        TextView txtShopName;
    }
}