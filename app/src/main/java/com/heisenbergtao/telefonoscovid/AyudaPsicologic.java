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

public class AyudaPsicologic extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout picogobierno, psicounam, psicouaslp,psicocentropotosino,psicoyucatan,psicozacatecas;
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
        setContentView(R.layout.activity_ayuda_psicologic);
        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        picogobierno = findViewById(R.id.btnbajas11);
        picogobierno.setOnClickListener(this);

        psicounam = findViewById(R.id.btnunam);
        psicounam.setOnClickListener(this);

        psicouaslp = findViewById(R.id.btnuaslp);
        psicouaslp.setOnClickListener(this);

        psicoyucatan = findViewById(R.id.btnyucatanpsi);
        psicoyucatan.setOnClickListener(this);

        psicocentropotosino = findViewById(R.id.btnpsico);
        psicocentropotosino.setOnClickListener(this);

        psicozacatecas = findViewById(R.id.btnzacatecaspsi);
        psicozacatecas.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnbajas11:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:8000044800"));
                startActivity(intent1);

                break;

            case R.id.btnunam:

                Intent intent12 = new Intent(Intent.ACTION_DIAL);
                intent12.setData(Uri.parse("tel:5025 0855"));
                startActivity(intent12);

                break;

            case R.id.btnuaslp:

                Intent intent13 = new Intent(Intent.ACTION_DIAL);
                intent13.setData(Uri.parse("tel:444 175 5579"));
                startActivity(intent13);

                break;

            case R.id.btnpsico:

                Intent intent14 = new Intent(Intent.ACTION_DIAL);
                intent14.setData(Uri.parse("tel:444 188 4707"));
                startActivity(intent14);

                break;

            case R.id.btnyucatanpsi:

                Intent intent145 = new Intent(Intent.ACTION_DIAL);
                intent145.setData(Uri.parse("tel:800 982 2826"));
                startActivity(intent145);

                break;

            case R.id.btnzacatecaspsi:

                Intent intent1457 = new Intent(Intent.ACTION_DIAL);
                intent1457.setData(Uri.parse("tel:492 303 8755"));
                startActivity(intent1457);

                break;
        }


    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            startActivity(new Intent(getBaseContext(), MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(getBaseContext(), MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}