package com.example.pttkht.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pttkht.R;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.model.objects.Category;
import com.squareup.picasso.Picasso;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class AdapterCategory extends BaseAdapter {


    @Override
    public int getCount() {
        return ManagerData.getIntance().getCategory().size();
    }

    @Override
    public Object getItem(int position) {
        return ManagerData.getIntance().getCategory().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder {
        private ImageView img;
        private TextView txtName;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_girdview, parent, false);
            myHolder = new MyHolder();
            myHolder.img = convertView.findViewById(R.id.imageView);
            myHolder.txtName = convertView.findViewById(R.id.name_catogery);
            convertView.setTag(myHolder);
        } else {
            myHolder = (MyHolder) convertView.getTag();
        }
        Category category = ManagerData.getIntance().getCategory().get(position);
        myHolder.txtName.setText(category.getName());
        //myHolder.img.setImageResource(R.drawable.combo);
        Picasso.with(parent.getContext()).load(category.getLinkImg()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myHolder.img);

        return convertView;
    }
}
