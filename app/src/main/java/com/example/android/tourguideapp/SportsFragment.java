package com.example.android.tourguideapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import androidx.fragment.app.Fragment;

public class SportsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tour_list, container,false);

        final ArrayList<TourLocation> locations = new ArrayList<TourLocation>();
        locations.add(new TourLocation(getString(R.string.mosaic), R.drawable.cheese_4));
        locations.add(new TourLocation(getString(R.string.golf), R.drawable.cheese_2));

        TourLocationAdapter adapter = new TourLocationAdapter(getActivity(), locations);
        GridView gridView = (GridView) rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TourLocation loc = locations.get(position);

                Intent SportsIntent = new Intent(getActivity(), TourDetailActivity.class);
                SportsIntent.putExtra(getString(R.string.TourLocationName), loc.getName());
                SportsIntent.putExtra(getString(R.string.TourLocationImage), loc.getThumbnailResourceID());
                startActivity(SportsIntent);

            }
        });

        return rootView;
    }
}
