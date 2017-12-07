package com.example.pttkht.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pttkht.R;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.model.objects.FastFood;
import com.squareup.picasso.Picasso;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class AdapterFastFood extends BaseAdapter{
    private int idCategory;

    public AdapterFastFood(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public int getCount() {
        return ManagerData.getIntance().getFastFood(idCategory).size();
    }

    @Override
    public Object getItem(int position) {
        return ManagerData.getIntance().getFastFood(idCategory).get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder {
        private ImageView img,shoppingCart;
        private TextView txtName,txtPrice;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MyHolder myHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);
            myHolder=new MyHolder();
            myHolder.img=convertView.findViewById(R.id.imageView);
            myHolder.shoppingCart=convertView.findViewById(R.id.shoppingcart);
            myHolder.txtName=convertView.findViewById(R.id.name_catogery);
            myHolder.txtPrice=convertView.findViewById(R.id.price_food);
            convertView.setTag(myHolder);
        }else {
            myHolder= (MyHolder) convertView.getTag();
        }
        FastFood fastFood= (FastFood) ManagerData.getIntance().getFastFood(idCategory).get(position);
        myHolder.txtName.setText(fastFood.getNameFood());
        myHolder.txtPrice.setText("Prices: "+fastFood.getPrices());
        Picasso.with(parent.getContext()).load(fastFood.getLinkImage()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(myHolder.img);
        myHolder.shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return convertView;
    }
}
