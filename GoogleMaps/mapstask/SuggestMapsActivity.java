package com.example.mapstask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

public class SuggestMapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_maps);

        // Fetching API_KEY which we wrapped
        ApplicationInfo ai = null;
        try {
            ai = getApplicationContext().getPackageManager()
                    .getApplicationInfo(getApplicationContext().getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String value = ai.metaData.getString("AIzaSyCjFVJmlQpdjKkngrFQxNqEeUZjL65Br9c");
        String apiKey = value;

        // Initializing the Places API with the help of our API_KEY
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }

        // Initialize AutocompleteSupportFragment
        AutocompleteSupportFragment autocompleteSupportFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapsuggest);

        if (autocompleteSupportFragment != null) {
            // Information that we wish to fetch after typing the location and clicking on one of the options
            autocompleteSupportFragment.setPlaceFields(Arrays.asList(
                    Place.Field.NAME,
                    Place.Field.ADDRESS,
                    Place.Field.PHONE_NUMBER,
                    Place.Field.LAT_LNG,
                    Place.Field.OPENING_HOURS,
                    Place.Field.RATING,
                    Place.Field.USER_RATINGS_TOTAL
            ));

            // Display the fetched information after clicking on one of the options
            autocompleteSupportFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
                @Override
                public void onError(@NonNull Status status) {
                    Toast.makeText(SuggestMapsActivity.this, "Some error occurred", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPlaceSelected(@NonNull Place place) {
                    TextView txtplace = findViewById(R.id.txtplace);

                    // Information about the place
                    String name = place.getName();
                    String address = place.getAddress();
                    String phoneNumber = place.getPhoneNumber();
                    LatLng latLng = place.getLatLng();
                    Double latitude = (latLng != null) ? latLng.latitude : null;
                    Double longitude = (latLng != null) ? latLng.longitude : null;

                    String isOpenStatus = (place.isOpen() != null && place.isOpen()) ? "Open" : "Closed";

                    Double rating = place.getRating();
                    Integer userRatings = place.getUserRatingsTotal();

                    txtplace.setText("Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phoneNumber + "\n" +
                            "Latitude, Longitude: " + latitude + " , " + longitude + "\nIs open: " + isOpenStatus + "\n" +
                            "Rating: " + rating + "\nUser ratings: " + userRatings);
                }
            });
        }
    }
}
