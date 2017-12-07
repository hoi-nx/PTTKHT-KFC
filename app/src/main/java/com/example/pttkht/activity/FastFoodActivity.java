package com.example.pttkht.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pttkht.IListFastFood;
import com.example.pttkht.adapter.AdapterFastFood;
import com.example.pttkht.model.ManagerData;
import com.example.pttkht.R;
import com.example.pttkht.model.objects.Category;
import com.example.pttkht.model.objects.FastFood;

import io.realm.Realm;

/**
 * Created by Heart Of Dead on 11/1/2017.
 */

public class FastFoodActivity extends AppCompatActivity implements IListFastFood {
    private Toolbar mToolBar;
    private AdapterFastFood adapterGirdView;




    private GridView mGridView;
    private Category category;
    private Realm mRealm;
    private TextView txtNumberOfShoopingCart;
    private boolean check;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fastfood_activity);
        Realm.init(this);
        mRealm = Realm.getDefaultInstance();

        initData();
        addControls();
        initEvents();
    }

    private void initEvents() {
        adapterGirdView = new AdapterFastFood(category.getIdCategory(),this);
        mGridView.setAdapter(adapterGirdView);

    }

    private void initData() {
        Intent intent = getIntent();
        category = (Category) intent.getSerializableExtra("CATOGERY");

    }

    private void addControls() {
        mToolBar = findViewById(R.id.toolbar);
        mGridView = findViewById(R.id.gv_fastfood);
        setSupportActionBar(mToolBar);
        getSupportActionBar().setTitle(category.getName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home_page_shopping_cart, menu);

        MenuItem menuItem = menu.findItem(R.id.shopping_cart);

        View shoppingCart = MenuItemCompat.getActionView(menuItem);
        txtNumberOfShoopingCart = shoppingCart.findViewById(R.id.txtNumberOfShoppingCart);
        txtNumberOfShoopingCart.setText(ManagerData.getIntance().getListOrderFood(mRealm).size() + "");
        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FastFoodActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    protected void onPause() {
        super.onPause();
        check=true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(check){
            txtNumberOfShoopingCart.setText(ManagerData.getIntance().getListOrderFood(mRealm).size() + "");
        }
    }

    @Override
    public void shoppingCart(int position) {
        FastFood fastFood = ManagerData.getIntance().getFastFood(category.getIdCategory()).get(position);
        int idFastFood = fastFood.getIdFastFood();
        if(ManagerData.getIntance().saveOrderFood(mRealm,idFastFood,category.getIdCategory(),fastFood.getPrices(),1)){
            Toast.makeText(FastFoodActivity.this, "Thêm vào giỏ hàng thành công", Toast.LENGTH_LONG).show();
            txtNumberOfShoopingCart.setText(ManagerData.getIntance().getListOrderFood(mRealm).size() + "");
        }else {
            Toast.makeText(FastFoodActivity.this, "Đã có trong giỏ hàng", Toast.LENGTH_LONG).show();
        }
    }
}
