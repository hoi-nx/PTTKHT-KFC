package com.example.pttkht.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pttkht.IList;
import com.example.pttkht.adapter.AdapterShoppingCart;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.R;
import com.example.pttkht.model.objects.FastFood;
import com.example.pttkht.model.ShoppingCart;

import java.text.DecimalFormat;

import io.realm.Realm;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class ShoppingCartActivity extends AppCompatActivity implements IList {
    private ListView recyclerView;
    private AdapterShoppingCart adapterShoppingCart;
    private Realm mRealm;
    private TextView txtTotal;
    private Button btnDatHang;
    DecimalFormat formatter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();
        formatter = new DecimalFormat("###,###,###.##");
        recyclerView=findViewById(R.id.rc_order);
        txtTotal=findViewById(R.id.total_list);
        btnDatHang=findViewById(R.id.dathang_);
        txtTotal.setText(formatter.format(ManagerData.getIntance().getTotalPriceListOder(mRealm))+" VND");

        adapterShoppingCart=new AdapterShoppingCart(mRealm,this);
        recyclerView.setAdapter(adapterShoppingCart);


        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ManagerData.getIntance().clearAllListOrder(mRealm)){
                    Toast.makeText(ShoppingCartActivity.this,"Thanks for your order",Toast.LENGTH_LONG).show();
                    txtTotal.setText(formatter.format(ManagerData.getIntance().getTotalPriceListOder(mRealm))+" VND");
                    adapterShoppingCart.notifyDataSetChanged();
                }
            }
        });



    }

    @Override
    public void deleteClick(int i) {

        ShoppingCart shoppingCart=ManagerData.getIntance().getListOrderFood(mRealm).get(i);
        if( ManagerData.getIntance().deleteOrderFood(mRealm,shoppingCart)){
            txtTotal.setText(formatter.format(ManagerData.getIntance().getTotalPriceListOder(mRealm))+" VND");
            adapterShoppingCart.notifyDataSetChanged();
            Toast.makeText(ShoppingCartActivity.this,"Delete thành công",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void countUp(int i) {
        ShoppingCart shoppingCart=ManagerData.getIntance().getListOrderFood(mRealm).get(i);
        FastFood fastFood=ManagerData.getIntance().getFood(shoppingCart.getIdFood(),shoppingCart.getIdCategory());
        int number=shoppingCart.getNumber();
        int price=fastFood.getPrices();
        int total=++number*price;
        if(ManagerData.getIntance().updateOrderFood(mRealm,shoppingCart,number,total)){
            txtTotal.setText(formatter.format(ManagerData.getIntance().getTotalPriceListOder(mRealm))+" VND");
            adapterShoppingCart.notifyDataSetChanged();
        }

    }
    @Override
    public void countDown(int i) {
            ShoppingCart shoppingCart=ManagerData.getIntance().getListOrderFood(mRealm).get(i);
            FastFood fastFood=ManagerData.getIntance().getFood(shoppingCart.getIdFood(),shoppingCart.getIdCategory());
            int number=shoppingCart.getNumber();
            int price=fastFood.getPrices();
            int total=--number*price;
            if(number<1){
                ManagerData.getIntance().deleteOrderFood(mRealm,shoppingCart);
                txtTotal.setText(ManagerData.getIntance().getTotalPriceListOder(mRealm)+" VND");
                adapterShoppingCart.notifyDataSetChanged();
                return;
            }
            if(ManagerData.getIntance().updateOrderFood(mRealm,shoppingCart,number,total)){
                txtTotal.setText(ManagerData.getIntance().getTotalPriceListOder(mRealm)+" VND");
                adapterShoppingCart.notifyDataSetChanged();
            }
        }

}
