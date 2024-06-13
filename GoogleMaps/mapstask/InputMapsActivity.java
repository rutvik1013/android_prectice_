package com.example.mapstask;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapstask.databinding.ActivityInputMapsBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityInputMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInputMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.inputmap);
        mapFragment.getMapAsync(this);

        binding.btncity.setOnClickListener(v->searchLocation());
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

    }
    private void searchLocation(){

        String location=binding.edtcity.getText().toString();
        if (location==null||location.equals("")){
            Toast.makeText(this, "Please Enter an Adress", Toast.LENGTH_SHORT).show();
            return;
        }

        Geocoder geocoder=new Geocoder(this);
        List<Address> adresslist;

        try {
          adresslist=geocoder.getFromLocationName(location,1);
            if (adresslist!=null&&adresslist.size()>0){
                Address address=adresslist.get(0);
                LatLng latLng=new LatLng(address.getLatitude(),address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(location));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,1));

            }
            else
            {
                Toast.makeText(this, "Location Not Found", Toast.LENGTH_SHORT).show();
            }

        }catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}