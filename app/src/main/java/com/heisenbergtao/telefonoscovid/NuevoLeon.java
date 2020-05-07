package com.heisenbergtao.telefonoscovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class NuevoLeon extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout btnbaja1, btnbaja2, btnbaja3;
    ColorDrawable dialogColor;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //botonatras
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.activity_nuevo_leon);
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        btnbaja1 = findViewById(R.id.btnbja1);
        btnbaja1.setOnClickListener(this);

        btnbaja2 = findViewById(R.id.btnbaja2);
        btnbaja2.setOnClickListener(this);

        btnbaja3 = findViewById(R.id.btnbaja3);
        btnbaja3.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnbja1:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse(" 818 361 0058"));
                startActivity(intent1);

                break;

            case R.id.btnbaja2:

                Intent intent12 = new Intent(Intent.ACTION_DIAL);
                intent12.setData(Uri.parse("tel:070"));
                startActivity(intent12);

                break;

            case R.id.btnbaja3:

                Intent intent13 = new Intent(Intent.ACTION_DIAL);
                intent13.setData(Uri.parse("tel:911"));
                startActivity(intent13);

                break;


        }


    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            startActivity(new Intent(getBaseContext(), TelefonosMexico.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(getBaseContext(), TelefonosMexico.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}