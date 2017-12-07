package com.example.pttkht.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.pttkht.R;
import com.example.pttkht.adapter.AdapterCategory;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.model.objects.Category;

import io.realm.Realm;

public class CategoryActivity extends AppCompatActivity{
    private Toolbar mToolBar;


    private AdapterCategory adapterCategory;
    private GridView mGridView;
    private TextView txtNumberOfShoopingCart;
    private Realm mRealm;
    private boolean check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();
        addControl();
        addEvent();


    }

    private void addEvent() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Category category = (Category) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(CategoryActivity.this, FastFoodActivity.class);
                intent.putExtra("CATOGERY", category);
                startActivity(intent);
            }
        });
    }

    private void addControl() {
        mToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle("Nguyễn Thị Team");
        mGridView = findViewById(R.id.gv_);
        adapterCategory = new AdapterCategory();
        mGridView.setAdapter(adapterCategory);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_page_shopping_cart, menu);
        MenuItem menuItem = menu.findItem(R.id.shopping_cart);
        View shoppingCart = MenuItemCompat.getActionView(menuItem);
        txtNumberOfShoopingCart = shoppingCart.findViewById(R.id.txtNumberOfShoppingCart);
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, ShoppingCartActivity.class);
                startActivity(intent);

            }
        });
        txtNumberOfShoopingCart.setText(ManagerData.getIntance().getListOrderFood(mRealm).size() + "");




        return super.onCreateOptionsMenu(menu);


    }

    @Override
    protected void onPause() {
        super.onPause();
        check = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (check) {
            txtNumberOfShoopingCart.setText(ManagerData.getIntance().getListOrderFood(mRealm).size() + "");
        }
    }



}
