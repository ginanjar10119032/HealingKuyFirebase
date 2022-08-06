package com.fightingspirit.healingkuy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mapView;
    public TextView lokasi, nama, alamat;
    public ImageView foto;

//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
//    {
//        super.onViewCreated(view, savedInstanceState);
//        mapView = view.findViewById(R.id.map);
//        mapView.onCreate(savedInstanceState);
//        mapView.onResume();
//        mapView.getMapAsync(this);
//    }
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState)
//    {
//        View view = inflater.inflate(R.layout.activity_map, container, false);
//        lokasi = view.findViewById(R.id.lokasi);
//        nama = view.findViewById(R.id.nama);
//        alamat = view.findViewById(R.id.alamat);
//
//        lokasi.setText("");
//        nama.setText("");
//        alamat.setText("");
//        return view;
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
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