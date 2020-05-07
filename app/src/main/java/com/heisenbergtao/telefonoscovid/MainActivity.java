package com.heisenbergtao.telefonoscovid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout btnhospital, btnpsicologica,btnemergencia, btndenunciar,btnprofeco,btnsusana,btnquejas, btninfopaciente,btnlineadirecta;
    ColorDrawable dialogColor;
    private AdView mAdView;
    int califica;
    InterstitialAd mInterstitialAd;
    SharedPreferences sharedPref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-9129010539844350/7943812005");
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest1);
        mInterstitialAd.setAdListener(new AdListener());

        sharedPref = getSharedPreferences("inicio", Context.MODE_PRIVATE);
        califica = sharedPref.getInt("califica", 0);

        if (califica == 8) {
            dialogocalifica();
            califica = 0;
        } else
            califica++;

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("califica", califica);
        editor.apply();


// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA

        btnlineadirecta = findViewById(R.id.btnlineadirecta);
        btnlineadirecta.setOnClickListener(this);

        btnhospital = findViewById(R.id.btnhospital);
        btnhospital.setOnClickListener(this);

        btndenunciar = findViewById(R.id.btndenunciar);
        btndenunciar.setOnClickListener(this);

        btnemergencia = findViewById(R.id.btnemergencia);
        btnemergencia.setOnClickListener(this);

        btnsusana = findViewById(R.id.btnsusana);
        btnsusana.setOnClickListener(this);

        btnprofeco = findViewById(R.id.btnprofeco);
        btnprofeco.setOnClickListener(this);

        btnpsicologica = findViewById(R.id.btnpsicologica);
        btnpsicologica.setOnClickListener(this);

        btnquejas = findViewById(R.id.btnquejas);
        btnquejas.setOnClickListener(this);

        btninfopaciente = findViewById(R.id.btninfopaci);
        btninfopaciente.setOnClickListener(this);



        validaPermisos();


    }


    private void dialogocalifica() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final LayoutInflater inflater = getLayoutInflater();
        View vi = inflater.inflate(R.layout.dialogocalifica, null);
        builder.setView(vi);
        final AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        ColorDrawable dialogColor = new ColorDrawable(Color.GRAY);
        dialogColor.setAlpha(0);
        dialog.getWindow().setBackgroundDrawable(dialogColor);
        Button botonsi = vi.findViewById(R.id.botonsi);
        botonsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentae4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.heisenbergtao.manualsupervivencia"));
                startActivity(intentae4);
            }
        });
        Button botonno = vi.findViewById(R.id.botonno);
        botonno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                mInterstitialAd.show();



            }
        });

        dialog.show();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnpsicologica:

                Intent intent11zq1e3s = new Intent(this, AyudaPsicologic.class);
                startActivity(intent11zq1e3s);
                finish();
                break;

            case R.id.btnemergencia:

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8000044800"));
                startActivity(intent);

                break;

            case R.id.btnhospital:

                Intent intent11zq1 = new Intent(this, Hospitales.class);
                startActivity(intent11zq1);
                finish();
                break;

            case R.id.btnlineadirecta:

                Intent intent11zq1e = new Intent(this, TelefonosMexico.class);
                startActivity(intent11zq1e);
                finish();
                break;

            case R.id.btninfopaci:

                Intent intent11zq1e3 = new Intent(this, InfoPaciente.class);
                startActivity(intent11zq1e3);
                finish();
                break;

            case R.id.btnprofeco:

                Intent intent11zq1e3q = new Intent(this, Profeca.class);
                startActivity(intent11zq1e3q);
                finish();
                break;



            case R.id.btnsusana:



                String msj = "Hola";
                String numeroTel = "+525586338589";

                Intent intent99 = new Intent(Intent.ACTION_VIEW);
                intent99.setPackage("com.whatsapp");
                String uri = "whatsapp://send?phone=" + numeroTel + "&text=" + msj;
                intent99.setData(Uri.parse(uri));
                Intent waIntent = new Intent(Intent.ACTION_SEND);
                waIntent.setType("text/plain");
                waIntent.putExtra(Intent.EXTRA_TEXT, msj);
                startActivity(Intent.createChooser(waIntent, "Compartir con:"));

                startActivity(intent99);


                break;


            case R.id.btnquejas:

                Intent intent11zq1q = new Intent(this, QuejasTrabajadoresImss.class);
                startActivity(intent11zq1q);
                finish();
                break;

            case R.id.btndenunciar:

                Intent intent12 = new Intent(Intent.ACTION_DIAL);
                intent12.setData(Uri.parse("tel:911"));
                startActivity(intent12);

                break;


        }


    }


    private void validaPermisos() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if ((checkSelfPermission(CALL_PHONE) == PackageManager.PERMISSION_GRANTED)) {
            return;
        }

        if ((shouldShowRequestPermissionRationale(CALL_PHONE))) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
            dialogo.setTitle("Permisos Desactivados");
            dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

            dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    requestPermissions(new String[]{ CALL_PHONE}, 100);
                }
            });
            dialogo.show();
        } else {
            requestPermissions(new String[]{ CALL_PHONE}, 100);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();

            View vi = inflater.inflate(R.layout.dialogoconfirm, null);
            builder.setView(vi);


            final AlertDialog dialog = builder.create();
            dialog.getWindow().setBackgroundDrawable(dialogColor);

            //decidir despues si sera cancelable o no
            dialog.setCancelable(false);
            Button botonsi = vi.findViewById(R.id.botonsi);
            botonsi.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();
                            MainActivity.super.onDestroy();
                            System.exit(0);
                        }
                    }
            );
            Button botonno = vi.findViewById(R.id.botonno);
            botonno.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.cancel();

                        }
                    }
            );
            dialog.show();
            //Metodos.dialogo( this, getLayoutInflater(), "¿seguro deseas salir de la aplicacion?", 0 );
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
