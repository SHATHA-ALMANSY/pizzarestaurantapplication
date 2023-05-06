package com.shada.shada_almansy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class location extends AppCompatActivity implements OnMapReadyCallback {

    Double Latitude = 31.41734082360799 ;
    Double Longitude =    34.3507279918639 ;
    String Titel = " معرض الحاطي للأحذية " ;
    String desc = " جميع اصناف الاحذية التركية " ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        runmap();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        googleMap.clear();
        LatLng obj = new LatLng(Latitude,Longitude);
        MarkerOptions options = new MarkerOptions().position(obj).title(Titel).snippet(desc);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(obj,17f));
        googleMap.addMarker(options);

    }

    public void runmap(){
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.goolemapfrag1);

        supportMapFragment.getMapAsync(this::onMapReady);

    }
}