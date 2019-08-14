package com.dicoding.submission.profligate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dicoding.submission.profligate.Adapter.CrimeListRecyclerViewAdapter;
import com.dicoding.submission.profligate.Model.Crime;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCrimeList;
    TextView tvListHeader;
    TextView tvTotalWasted;
    ImageButton profileBtn;
    List<Crime> crimeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCrimeList = findViewById(R.id.rvCrimeList);
        tvListHeader = findViewById(R.id.tvListHeader);
        tvTotalWasted = findViewById(R.id.tvTotalWasted);
        profileBtn = findViewById(R.id.profileBtn);

        init();

        NumberFormat formatter = new DecimalFormat("#,###");
        int totalWasted = 0;
        for(int i = 0; i < crimeList.size();i++){
            totalWasted += crimeList.get(i).getPrice();
        }
        String formattedNumber = formatter.format(totalWasted);
        String finalFormat = "Total Money Wasted: Rp " + formattedNumber + ".00";
        tvTotalWasted.setText(finalFormat);

        CrimeListRecyclerViewAdapter adapter = new CrimeListRecyclerViewAdapter(this, crimeList);
        rvCrimeList.setLayoutManager(new LinearLayoutManager(this));
        rvCrimeList.setAdapter(adapter);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
//        for(int i = 0; i < 10; i++){
//            Crime crime = new Crime();
//            String title = "Crime " + (i+1);
//            crime.setTitle(title);
//            int price = (i + 1) * 12000;
//            crime.setPrice(price);
//            crime.setImgURL(R.mipmap.ic_launcher);
//            crimeList.add(crime);
//        }
        Crime data1 = new Crime();
        data1.setTitle("PG Gundam - RX-78-2 Real Type Color Limited Production");
        data1.setPrice(2025000);
        data1.setImgURL(R.mipmap.crime1);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("EVGA GeForce RTX 2080 Ti BLACK EDITION GAMING");
        data1.setPrice(19400000);
        data1.setImgURL(R.mipmap.crime3);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("PG Gundam - RX-0 Unicorn Gundam");
        data1.setPrice(2650000);
        data1.setImgURL(R.mipmap.crime2);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Shock Ohlins Yamaha Xmax 250");
        data1.setPrice(8650000);
        data1.setImgURL(R.mipmap.crime4);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Hatsune Miku -Hanairogoromo- 1/8 Figure");
        data1.setPrice(6000000);
        data1.setImgURL(R.mipmap.crime5);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Hotwheels Datsun 510 Wagon 50th Aniv");
        data1.setPrice(500000);
        data1.setImgURL(R.mipmap.crime6);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Hot Wheels Cars & Donuts");
        data1.setPrice(450000);
        data1.setImgURL(R.mipmap.crime7);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Days Gone PS4 Game");
        data1.setPrice(629000);
        data1.setImgURL(R.mipmap.crime8);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("Switch New Super Mario Bros U Deluxe(Asia/English)");
        data1.setPrice(690000);
        data1.setImgURL(R.mipmap.crime9);
        crimeList.add(data1);

        data1 = new Crime();
        data1.setTitle("SHFiguarts SHF Ironman MK42 Action Figure");
        data1.setPrice(449700);
        data1.setImgURL(R.mipmap.crime10);
        crimeList.add(data1);
    }
}
