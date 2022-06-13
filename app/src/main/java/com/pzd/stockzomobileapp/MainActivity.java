package com.pzd.stockzomobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;

    MarketFragment marketFragment = new MarketFragment();
    PortfolioFragment portfolioFragment = new PortfolioFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Stocks");

        getSupportFragmentManager().beginTransaction().replace(R.id.container, marketFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.market:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, marketFragment).commit();
                        return true;

                    case R.id.portfolio:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, portfolioFragment).commit();
                        return true;
                }

                return false;
            }
        });


    }
}