package com.example.mapstask;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.mapstask.databinding.ActivityModeMapsBinding;

public class ModeMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityModeMapsBinding binding;
    private  FusedLocationProviderClient fusedLocationProviderClient;
    private static int LOCATION_PERMISSION_REQUEST_CODE=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityModeMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.map_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.mapspinner.setAdapter(adapter);

        binding.mapspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (mMap!=null){
                    switch (position){
                        case 0:
                            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            break;

                        case 1:
                            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            break;

                        case 2:
                            mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                            break;

                        case 3:
                            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            break;


                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(getApplicationContext());

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
        enableMyLocation();

    }
    private void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},LOCATION_PERMISSION_REQUEST_CODE);

        }
        else {
            mMap.setIndoorEnabled(true);
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(this,location -> {
               if (location!=null){
                   LatLng currentlocation=new LatLng(location.getLatitude(),location.getLongitude());
                   mMap.addMarker(new MarkerOptions().position(currentlocation).title("You are here"));
                   mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentlocation,16f));

               }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==LOCATION_PERMISSION_REQUEST_CODE){
            if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                enableMyLocation();
            }
        }
    }
}