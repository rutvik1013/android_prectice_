package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_nav);
                                // Replicated
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();

                if (id==R.id.nav_home){
                    loadFragment(new HomeFragment());
                }
                else if (id==R.id.nav_category){
                    loadFragment(new CatogeryFragment());
                }
                else if (id==R.id.nav_notification){
                    loadFragment(new NotificationFragment());
                }
                else if (id==R.id.nav_account){
                    loadFragment(new AccountFragment());
                }
                else
                {
                    loadFragment(new CartFragment());
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.nav_category);
    }
    public void loadFragment(Fragment fragment){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fram_container,fragment);
        ft.commit();
    }
}