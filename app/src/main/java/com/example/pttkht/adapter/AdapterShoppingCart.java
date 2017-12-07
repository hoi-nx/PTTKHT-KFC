package com.example.pttkht.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pttkht.IList;
import com.example.pttkht.R;
import com.example.pttkht.activity.ShoppingCartActivity;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.model.ShoppingCart;
import com.example.pttkht.model.objects.FastFood;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Heart Of Dead on 07/12/2017.
 */

public class AdapterShoppingCart extends BaseAdapter {
    private Realm realm;
    private IList iList;

    public AdapterShoppingCart(Realm realm, IList iList) {
        this.realm = realm;
        this.iList = iList;
    }

    @Override
    public int getCount() {
        return ManagerData.getIntance().getListOrderFood(realm).size();
    }

    @Override
    public Object getItem(int i) {
        return ManagerData.getIntance().getListOrderFood(realm).get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View itemView, ViewGroup viewGroup) {
        itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shopping_cart, viewGroup, false);
        ImageView imgIcon = itemView.findViewById(R.id.img_kfc);

        TextView txtNameFood = itemView.findViewById(R.id.txt_name_bami);
        TextView txtTotalPrice = itemView.findViewById(R.id.total_price);
        ShoppingCart shoppingCart = ManagerData.getIntance().getListOrderFood(realm).get(i);
        FastFood fastFood = ManagerData.getIntance().getFood(shoppingCart.getIdFood(), shoppingCart.getIdCategory());
        Picasso.with(itemView.getContext()).load(fastFood.getLinkImage()).error(R.mipmap.ic_launcher).into(imgIcon);
        txtNameFood.setText(fastFood.getNameFood());
        txtTotalPrice.setText(shoppingCart.getNumber() + " x " + fastFood.getPrices() + "=" + shoppingCart.getTotalPrices());
        itemView.findViewById(R.id.img_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iList.deleteClick(i);
            }


        });
        itemView.findViewById(R.id.count_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iList.countDown(i);
            }
        });
        itemView.findViewById(R.id.count_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iList.countUp(i);
            }
        });
        return itemView;
    }


}
