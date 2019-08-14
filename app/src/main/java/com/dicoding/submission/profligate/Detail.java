package com.dicoding.submission.profligate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dicoding.submission.profligate.Model.Crime;
import com.dicoding.submission.profligate.Model.CrimeDetail;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Detail extends AppCompatActivity {

    ImageButton detail_backBtn;
    TextView tvDetailName;
    TextView tvDetailWasted;
    TextView tvDetailTime;
    TextView tvDetailDate;
    TextView tvDetailDesc;
    ImageView imgDetail;

    List<CrimeDetail> detailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int idx = getIntent().getIntExtra("index", 0);
        String name = getIntent().getStringExtra("name");
        int price = getIntent().getIntExtra("wasted", 0);
        int picture = getIntent().getIntExtra("picture", 0);

        init();

        detail_backBtn = findViewById(R.id.detail_backBtn);
        tvDetailName = findViewById(R.id.tvDetailName);
        tvDetailWasted = findViewById(R.id.tvDetailWasted);
        tvDetailDate = findViewById(R.id.tvDetailDate);
        tvDetailTime = findViewById(R.id.tvDetailTime);
        tvDetailDesc = findViewById(R.id.tvDetailDesc);
        imgDetail = findViewById(R.id.imgDetail);

        String formattedNumber = NumberFormat.getNumberInstance(Locale.UK).format(price);
        String priceMod = "Total wasted: Rp " + formattedNumber + ".00";
        String DetailDate = detailList.get(idx).getDate();
        String DetailTime = detailList.get(idx).getTime();

        tvDetailName.setText(name);
        tvDetailWasted.setText(priceMod);
        Glide.with(this).load(picture).into(imgDetail);

        tvDetailDate.setText(DetailDate);
        tvDetailTime.setText(DetailTime);
        tvDetailDesc.setText(detailList.get(idx).getDesc());

        detail_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });
    }

    public void init(){
        CrimeDetail data1 = new CrimeDetail();
        data1.setDate("01/08/2019");
        data1.setTime("19:30");
        data1.setDesc("Limited edition Gundam, I dunno if there will be another chance to get this one :(");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("03/08/2019");
        data1.setTime("10:33");
        data1.setDesc("Need new GPU to play Assassin's Creed Odyssey in maximum FPS... not regretting this buy.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("03/08/2019");
        data1.setTime("13:21");
        data1.setDesc("Finally the store has the stock. I'm buying it whatever it costs.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("04/08/2019");
        data1.setTime("11:58");
        data1.setDesc("This thing is a good investment for my spine. Jakarta's roads are barbaric.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("04/08/2019");
        data1.setTime("12:33");
        data1.setDesc("Hatsune Miku! You're going into my shelves.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("05/08/2019");
        data1.setTime("16:12");
        data1.setDesc("How can I not buy this thing? Rare, limited edition, still looks great.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("07/08/2019");
        data1.setTime("15:33");
        data1.setDesc("Another Hot Wheels collection worth to buy. Got a full set in sweet condition.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("08/08/2019");
        data1.setTime("16:33");
        data1.setDesc("This is a great game. I'm buying it. Lots and lots of zombies, great stories, open roads and bikes.. who can say no to it?");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("09/08/2019");
        data1.setTime("10:36");
        data1.setDesc("Heeyy, just got a new Switch but no games yet. So this is my first game, better this than letting that Switch turns into a useless junk.");
        detailList.add(data1);

        data1 = new CrimeDetail();
        data1.setDate("10/08/2019");
        data1.setTime("08:23");
        data1.setDesc("Always a fan to Mk42, modular design is really cool.. it'll add charm to my collection.");
        detailList.add(data1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
