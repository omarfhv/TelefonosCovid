package com.heisenbergtao.telefonoscovid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.Manifest.permission.SEND_SMS;

public class BajaCalifornia extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout btnbaja1, btnbaja2, btnbaja3,btnbaja4;
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
        setContentView(R.layout.activity_baja_california);
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

        btnbaja4 = findViewById(R.id.btnbaja4);
        btnbaja4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnbja1:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:686 304 8048"));
                startActivity(intent1);

                break;

            case R.id.btnbaja2:

                Intent intent12 = new Intent(Intent.ACTION_DIAL);
                intent12.setData(Uri.parse("tel:664 108 2528"));
                startActivity(intent12);

                break;

            case R.id.btnbaja3:

                Intent intent13 = new Intent(Intent.ACTION_DIAL);
                intent13.setData(Uri.parse("tel:646 239 0955"));
                startActivity(intent13);

                break;

            case R.id.btnbaja4:

                Intent intent14 = new Intent(Intent.ACTION_DIAL);
                intent14.setData(Uri.parse("tel:646 947 5408"));
                startActivity(intent14);

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