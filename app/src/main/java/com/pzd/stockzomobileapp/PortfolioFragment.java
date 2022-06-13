package com.pzd.stockzomobileapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PortfolioFragment extends Fragment {

    View view;

    public TextView totalRs, totalQuantity;
    CardView cardView;
    public Button sellBtn;
    String str1, str2;

    public PortfolioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_portfolio, container, false);

        totalRs = view.findViewById(R.id.total_rupees);
        totalQuantity  = view.findViewById(R.id.total_quantity);
        sellBtn = view.findViewById(R.id.sell_stock);
        cardView = view.findViewById(R.id.cardView);

        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                str1 = result.getString("price");
                str2 = result.getString("quantity");

                totalRs.setText("Rs."+str1);
                totalQuantity.setText(str2);
            }
        });

        sellBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(),"Stock Sold Quantity "+str2+" Price Rs."+str1,Toast.LENGTH_SHORT).show();

                cardView.setVisibility(view.INVISIBLE);

            }
        });

        return view;

    }
}