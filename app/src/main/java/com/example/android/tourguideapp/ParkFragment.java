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

public class ParkFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tour_list, container, false);

        //regina parks exhibition
        final ArrayList<TourLocation> locations = new ArrayList<TourLocation>();
        locations.add(new TourLocation(getString(R.string.norseman_park), R.drawable.cheese_3));
        locations.add(new TourLocation(getString(R.string.kiwanis_waterfall), R.drawable.cheese_5));
        locations.add(new TourLocation(getString(R.string.victoria_park), R.drawable.cheese_1));
        locations.add(new TourLocation(getString(R.string.wascana_centre), R.drawable.cheese_4));

        TourLocationAdapter adapter = new TourLocationAdapter(getActivity(), locations);

        GridView gridView = (GridView) rootView.findViewById(R.id.list);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TourLocation loc = locations.get(position);

                Intent ParkIntent = new Intent(getActivity(), TourDetailActivity.class);
                ParkIntent.putExtra(getString(R.string.TourLocationName), loc.getName());
                ParkIntent.putExtra(getString(R.string.TourLocationImage), loc.getThumbnailResourceID());
                startActivity(ParkIntent);

            }
        });

        return rootView;
    }
}
