
/*******   This page used to design the gridView using BaseAdapter foe Service ********/


package com.prolink.loundry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid_service_laundary extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;
    private final String[] item_price;

    public CustomGrid_service_laundary(Context c, String[] web, int[] Imageid, String[] price) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
        this.item_price = price;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single_inhouse_order, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            TextView price = (TextView)grid.findViewById(R.id.grid_price);
            textView.setText(web[position]);
            imageView.setImageResource(Imageid[position]);
            price.setText(item_price[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}


