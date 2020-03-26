package com.example.android.tourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class TourLocationAdapter extends ArrayAdapter <TourLocation> {

    public TourLocationAdapter(Activity context, ArrayList<TourLocation> Words) {

        super(context, 0, Words);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemViewRow = convertView;

        if(listItemViewRow == null) {

            listItemViewRow = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false); //the assign false because we dont want to attach the list item view to the parent list view just yet
        }

        final TourLocation currentWord = getItem(position);

        TextView nameTextView = (TextView) listItemViewRow.findViewById(R.id.location);
        nameTextView.setText(currentWord.getName());

        ImageView imageView = (ImageView) listItemViewRow.findViewById(R.id.thumbnail);
         imageView.setImageResource(currentWord.getThumbnailResourceID());


        return listItemViewRow;
    }
}
