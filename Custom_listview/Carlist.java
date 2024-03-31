package com.example.customlist_car;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Carlist extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carlist);

        listView=findViewById(R.id.carlistname);

        Intent i=getIntent();
        int position=i.getIntExtra("position",101);

        ArrayList<Car_list_model>carlist=new ArrayList<>();



        if (position==0){
                carlist.add(new Car_list_model(R.drawable.bmwx1_,"BMW X1","Price: 49.50 Lakhs"));
                carlist.add(new Car_list_model(R.drawable.bmwx2,"BMW X2","Price: 45 Lalhs"));
                carlist.add(new Car_list_model(R.drawable.bmwx3,"BMW X3","Price: 68.50 Lakhs"));
                carlist.add(new Car_list_model(R.drawable.bmwx4,"BMW X4","Price: 96.20 Lakhs"));
                carlist.add(new Car_list_model(R.drawable.bmwx5,"BMW X5","Price: 1.09 Crore"));
                carlist.add(new Car_list_model(R.drawable.bmwx6,"BMW X6","Price: 1.04 Crore"));
                carlist.add(new Car_list_model(R.drawable.bmwx7,"BMW X7","Price: 1.24 Crore"));
                carlist.add(new Car_list_model(R.drawable.bmwxm,"BMW XM","Price: 2.60 Crore"));
                carlist.add(new Car_list_model(R.drawable.bmwm3,"BMW M3","Price: 99.90 Lakhs"));
                carlist.add(new Car_list_model(R.drawable.bmwm4,"BMW M4","Price: 1.73 Crore"));

        }
        if (position==1){
            carlist.add(new Car_list_model(R.drawable.audiq3,"Audi Q3","Price: 43.81 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audiq5,"Audi Q5","Price: 65.18 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audiq6,"Audi Q6","Price: 55 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audiq7_,"Audi Q7","Price: 94.45 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audiq8,"Audi Q8","Price: 1.43 Crore"));
            carlist.add(new Car_list_model(R.drawable.audis5,"Audi S5","Price: 75.80 Lalhs"));
            carlist.add(new Car_list_model(R.drawable.audia4,"Audi A4","Price: 45.34 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audia6,"Audi A6","Price: 64.07 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.audi_etron,"Audi etron","Price: 1.02 Crore"));
            carlist.add(new Car_list_model(R.drawable.audirsq8,"Audi RS Q8","Price: 2.22 Crore"));
        }
        if (position==2){
            carlist.add(new Car_list_model(R.drawable.kiasonet,"Kia Sonet","Price: 7.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiaseltos,"Kia Seltos","Price: 20.30 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiacarens,"Kia Carens","Price: 10.45 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiasonet,"Kia Sonet","Price: 7.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiaev6_,"Kia Ev6","Price: 60.95 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiaev5,"Kia Ev5","Price: 55 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiasportege,"Kia Sportage","Price: 25 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiak900,"Kia K900","Price: 63.60 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiaev9,"Kia Ev9","Price: 80 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.kiaclavis,"Kia Clavis","Price: 6.00 Lakhs"));
        }
        if (position==3){
            carlist.add(new Car_list_model(R.drawable.tatanexon,"Tata Nexon","Price: 8.15 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatapaunch,"Tata Paunch","Price: 6.13 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tataherrier,"Tata Harrier","Price: 15.49 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tataaltroz,"Tata Altroz","Price: 6.65 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatasafari,"Tata Safari","Price: 16.19 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatapaunch_ev,"Tata Paunch Ev","Price: 10.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatatiago,"Tata Tiago","Price: 5.65 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tata_nexon_ev,"Tata Nexon Ev","Price: 14.49 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatatiago_ev,"Tata Tiago Ev","Price: 7.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.tatatigar,"Tata Tigor","Price: 6.30 Lakhs"));
        }
        if (position==4) {
            carlist.add(new Car_list_model(R.drawable.toyota_innovo_crysta, "Toyota Inovo Crysta", "Price: 19.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_innovo_hycross, "Toyota Inovo Hycross", "Price: 19.77 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_rumion, "Toyota Rumion", "Price: 10.44 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_glanza, "Toyota Glanza", "Price: 6.86 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_fortuner, "Toyota Fortuner", "Price: 33.45 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_fortuner_legender, "Toyota Fortuner legender", "Price: 43.66 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_land_cruiser, "Toyota Land Cruiser", "Price: 2.10 Crore"));
            carlist.add(new Car_list_model(R.drawable.toyota_camry, "Toyota Camry", "Price: 48.17 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_belta,"Toyota Belta","Price: 9.00 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.toyota_bz4x,"Toyota BZ4X","Price: 60.00 Lakhs"));

        }
        if (position==5){
            carlist.add(new Car_list_model(R.drawable.skoda_slavia,"Skoda Slavia","Price: 11.53 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.skoda_kushaq,"Skoda Kushaq","Price: 11.89 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.skoda_octavia,"Skoda Octavia","Price: 27.35 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.skoda_enyaq,"Skoda Enyaq","Price: 50.00 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.skoda_superb,"Skoda Superb","Price: 28.00 Lakhs"));

        }
        if (position==6){
            carlist.add(new Car_list_model(R.drawable.hyundai_creta,"Hyundai Creta","Price: 11.00 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_exter,"Hyundai Exter","Price: 6.13 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_vanue,"Hyundai Vanue","Price: 7.94 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_verna,"Hyundai Verna","Price: 11.00 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_i20,"Hyundai i20","Price: 7.04 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_grand_i10_nios,"Hyundai Grand i10 Nios","Price: 5.92 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_aura,"Hyundai Aura","Price: 6.49 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_alcazar,"Hyundai Alcazar","Price: 16.77 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_venue_n_line,"Hyundai Venue N Line","Price: 12.08 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.hyundai_tucson,"Hyundai Tucson","Price: 29.02 Lakhs"));
        }
        if (position==7){
            carlist.add(new Car_list_model(R.drawable.ford_mustang,"Ford Mustang","Price: 74.15 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_classic,"Ford Classic","Price: 5.12 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_aspire,"Ford Aspire","Price: 7.28 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_endeavour,"Ford Endeavour","Price: 50 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_fiesta,"Ford Fiesta","Price: 8.68 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_figo,"Ford Figo","Price: 5.82 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_eco_sport,"Ford Eco Sport","Price: 7.91 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.ford_freestyle,"Ford Freestyle","Price: 5.91 Lakhs"));

        }
        if (position==8){
            carlist.add(new Car_list_model(R.drawable.mahindra_scorpio_n_,"Mahindra Scorpio N","Price: 13.60 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_scorpio,"Mahindra Scorpio ","Price: 13.59 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_thar,"Mahindra Thar","Price: 11.25 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_thar_e,"Mahindra Thar.e","Price: 20.00 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_xuv_700,"Mahindra XUV 700","Price: 13.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_xuv_300,"Mahindra XUV 300","Price: 7.99 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_xuv_400,"Mahindra XUV 400","Price: 15.49 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_bolero,"Mahindra Bolero","Price: 9.90 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_bolero_neo,"Mahindra Bolero Neo","Price: 9.90 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.mahindra_suv_500,"Mahindra XUV 500","Price: 20.09 Lakhs"));

        }
        if (position==9){
            carlist.add(new Car_list_model(R.drawable.porche_911,"Porche 911","Price: 1.86 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_912,"Porche 912","Price: 1.87 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_macan,"Porche Macan","Price: 88.06 Lakhs"));
            carlist.add(new Car_list_model(R.drawable.porche_cayenne,"Porche Cayenne","Price: 1.36 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_718,"Porche 718","Price: 1.48 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_panamera,"Porche Panamera","Price: 1.68 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_tycon,"Porche Tycan","Price: 1.61 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_cayenne_coupe,"Porche Cayenne Coupe","Price: 1.42 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_mecan_turbo_ev,"Porche Macan Turbo Ev","Price: 1.65 Crore"));
            carlist.add(new Car_list_model(R.drawable.porche_boxter,"Porche Boxter","Price: 1.52 Crore"));
        }

        Carlistadapter adapter=new Carlistadapter(this,carlist);
        listView.setAdapter(adapter);
    }
}