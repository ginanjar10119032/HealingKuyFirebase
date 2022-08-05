package com.fightingspirit.healingkuy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapActivity extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    public TextView title,alamat1,alamat2;

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_map, container, false);
        title = view.findViewById(R.id.txt1);
        alamat1 = view.findViewById(R.id.txt2);
        alamat2 = view.findViewById(R.id.txt3);

        title.setText("");
        alamat1.setText("");
        alamat2.setText("");
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap)
    {
        mMap = googleMap;

        //passing lat long value
        LatLng wisata = new LatLng(-6.95766584638914, 107.68025879908926);

        //passing title
        MarkerOptions mark = new MarkerOptions().position(wisata).title("Sebuah Tempat");

        mMap.addMarker(mark);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(wisata,13));
    }
}