package com.example.mymaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mymaps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

import java.io.IOException;
import java.util.ArrayList;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;

        LatLng latLng=new LatLng(21.615126415423816, 70.21800482055382);
        MarkerOptions markerOptions=new MarkerOptions().position(latLng).title("Thaniyana");
        mMap.addMarker(markerOptions);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));



        // circle

        mMap.addCircle(new CircleOptions()
                .center(latLng)
                .radius(500).fillColor(Color.DKGRAY)
                .strokeColor(Color.RED));

        // Polygon

        mMap.addPolygon(new PolygonOptions().add(new LatLng(22.31561994224747, 70.80018464376369),
                new LatLng(23.021674666600568, 72.57236674667617),
                new LatLng(22.310585497642787, 73.18061699453773),
                new LatLng(21.18025053194047, 72.81403397898669),
                new LatLng(19.087149122118053, 72.87285454694158),
                new LatLng(12.969849962519477, 77.56630027095194),
                new LatLng(28.617166444948342, 77.22223519761565)).fillColor(Color.WHITE).strokeColor(Color.BLACK));

//        // GroundOverlay
//
        mMap.addGroundOverlay(new GroundOverlayOptions()
                .position(latLng,1000f,1000f)
                .image(BitmapDescriptorFactory.fromResource(R.drawable.bmwx6)).clickable(true));


        // Geocoder
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                mMap.addMarker(new MarkerOptions().position(latLng).title("Clicked here"));

                Geocoder geocoder=new Geocoder(MapsActivity.this);

                try {
                    ArrayList<Address>adress=(ArrayList<Address>)geocoder.getFromLocation(latLng.latitude,latLng.longitude,1);
                    Log.d("adress",adress.get(0).getAddressLine(0));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}