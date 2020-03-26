package com.example.android.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class TourDetailActivity extends AppCompatActivity {
   // private Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tours_detail);

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        //setActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.favourite);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Added to Favourtes", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Intent intent = getIntent();
        final String tourName = getIntent().getStringExtra("TourLocationName");

        Log.v("TourName/detail: ", tourName);

        /*CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(tourName);*/

        TextView textView = (TextView) findViewById(R.id.tourLoc);
        textView.setText(tourName);

        /*final Toolbar toolbar = findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);*/

        getSupportActionBar().setDisplayShowTitleEnabled(false); //removes the title of your action bar

        loadBackdrop();
    }

    private void loadBackdrop() {
        final ImageView imageView = findViewById(R.id.backdrop);

        Glide.with(this).load(getIntent().getIntExtra("TourLocationImage", 0)).apply(RequestOptions.centerCropTransform()).into(imageView);
    }

}
