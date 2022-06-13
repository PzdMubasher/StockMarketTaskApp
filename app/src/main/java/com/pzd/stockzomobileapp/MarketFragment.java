package com.pzd.stockzomobileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MarketFragment extends Fragment {

    View view;

    TextView rs, minus,plus;
    Button buyBtn;
    EditText quantity;
    int value=0;
    int price=250;
    int totalPrice;

    public MarketFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_market, container, false);

        rs = view.findViewById(R.id.rupees);
        minus = view.findViewById(R.id.minus_b);
        plus = view.findViewById(R.id.add_b);
        buyBtn = view.findViewById(R.id.buy_stock);
        quantity = view.findViewById(R.id.quantity);
        quantity.setText("0");


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value++;
                quantity.setText(String.valueOf(value));

                totalPrice = value*price;
                rs.setText(String.valueOf("Rs."+totalPrice));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (value>0){
                    value--;
                    quantity.setText(String.valueOf(value));

                    totalPrice = value*price;
                    rs.setText(String.valueOf("Rs."+totalPrice));
                }

            }
        });

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Stock Purchased Quantity "+value+" Price Rs."+totalPrice,Toast.LENGTH_SHORT).show();

                Bundle result = new Bundle();
                result.putString("price",String.valueOf(totalPrice));
                result.putString("quantity",String.valueOf(value));
                getParentFragmentManager().setFragmentResult("dataFrom1",result);


            }
        });
        return view;

    }
}