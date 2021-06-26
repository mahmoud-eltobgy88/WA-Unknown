package com.example.android.whatsunknown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView share= findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent= new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"WA Unknown APP");
                String string= "Check out WA Unknown APP. I found it the best for texting unsaved contacts in wats app. https://appgallery.cloud.huawei.com/ag/n/app/C104126773?locale=en_US&source=appshare&subsource=C104126773";
                shareIntent.putExtra(Intent.EXTRA_TEXT,string);
                startActivity(Intent.createChooser(shareIntent,"Share Via"));
            }
        });

        ImageView info=findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),info.class));
            }
        });

        com.hbb20.CountryCodePicker ccp = findViewById(R.id.ccp);
        com.google.android.material.textfield.TextInputEditText no = findViewById(R.id.no);

        Button start= findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://api.whatsapp.com/send?phone=";
                Intent i = new Intent(Intent.ACTION_VIEW);
                String country =ccp.getFullNumber();
                String number=no.getText().toString();
                i.setData(Uri.parse(url+country+number));
                startActivity(i);
            }
        });


    }
}