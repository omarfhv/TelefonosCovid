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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.SEND_SMS;

public class Cdmx extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout botonllamada1, botonllamada;
    ColorDrawable dialogColor;
    private AdView mAdView;
    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //botonatras
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        setContentView(R.layout.activity_cdmx);


        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2736592244570345/8278638328");
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest1);
        mInterstitialAd.setAdListener(new AdListener());

// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        botonllamada = findViewById(R.id.botonllamadacdmx);
        botonllamada.setOnClickListener(this);

        botonllamada1 = findViewById(R.id.botonmensaje);
        botonllamada1.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.botonllamadacdmx:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:555 658 1111"));
                startActivity(intent1);

                break;

            case R.id.botonmensaje:

             //   String phone = "51515";
               // String text = "covid19";
                //SmsManager sms = SmsManager.getDefault();
                //sms.sendTextMessage(phone, null, text , null, null);

                final AlertDialog.Builder builders = new AlertDialog.Builder(Cdmx.this);
                final LayoutInflater inflater = getLayoutInflater();
                View vis = inflater.inflate(R.layout.mensje, null);
                builders.setView(vis);
                final AlertDialog dialogo = builders.create();
                dialogo.setCancelable(true);
                dialogo.getWindow().setBackgroundDrawable(dialogColor);
                Button botonoko = vis.findViewById(R.id.botoncont);
                botonoko.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialogo.dismiss();
                        mInterstitialAd.show();


                    }
                });


                dialogo.show();


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