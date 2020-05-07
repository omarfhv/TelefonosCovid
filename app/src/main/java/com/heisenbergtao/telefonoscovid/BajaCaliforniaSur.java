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

public class BajaCaliforniaSur extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout btnbajas1, btnbajas2;
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
        setContentView(R.layout.activity_baja_california_sur);
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        btnbajas1 = findViewById(R.id.btnbajas1);
        btnbajas1.setOnClickListener(this);

        btnbajas2 = findViewById(R.id.btnbajas2);
        btnbajas2.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnbajas1:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:612 199 5386"));
                startActivity(intent1);

                break;

            case R.id.btnbajas2:

                Intent intent12 = new Intent(Intent.ACTION_DIAL);
                intent12.setData(Uri.parse("tel:624 228 6855"));
                startActivity(intent12);

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