package com.heisenbergtao.telefonoscovid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static android.Manifest.permission.CALL_PHONE;

public class TelefonosMexico extends AppCompatActivity implements View.OnClickListener {


    private static final int SOLICITUD_PERMISO_CALL_PHONE = 1;
    private Intent intentllamada;
    LinearLayout cdmx,aguascalientes,bajacalifornia,bajacaliforniasur,campeche,coahuila,colima,chiapas,chihu,durango,guanajuato,guerrero,hidalgo,jalisco,estado,michoacan,morelos,nayarit,nuevoleon,oaxaca,puebla,queretaro,quintana,sanluis, sinaloa,sonora,tabasco,tamaulipas,tlaxcala,veracruz,yucatan,zacatecas;
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
        setContentView(R.layout.activity_telefonos_mexico);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


// SI NOS CONCEDE EL PERMISO Y LANZA LA LLAMADA


        cdmx = findViewById(R.id.btncdmx);
        cdmx.setOnClickListener(this);

        aguascalientes = findViewById(R.id.btnaguascalientes);
        aguascalientes.setOnClickListener(this);

        bajacalifornia = findViewById(R.id.btnbajacalifornia);
        bajacalifornia.setOnClickListener(this);

        bajacaliforniasur = findViewById(R.id.btnbajacaliforniasur);
        bajacaliforniasur.setOnClickListener(this);

        campeche = findViewById(R.id.btncampeche);
        campeche.setOnClickListener(this);

        coahuila = findViewById(R.id.btncoahuila);
        coahuila.setOnClickListener(this);

        colima = findViewById(R.id.btncolima);
        colima.setOnClickListener(this);

        chiapas = findViewById(R.id.btnchiapas);
        chiapas.setOnClickListener(this);

        chihu = findViewById(R.id.btnchihu);
        chihu.setOnClickListener(this);

        durango = findViewById(R.id.btndurango);
        durango.setOnClickListener(this);

        guanajuato = findViewById(R.id.btnguanajuato);
        guanajuato.setOnClickListener(this);

        guerrero = findViewById(R.id.btnguerrero);
        guerrero.setOnClickListener(this);

        hidalgo = findViewById(R.id.btnhidalgo);
        hidalgo.setOnClickListener(this);

        jalisco = findViewById(R.id.btnjalisco);
        jalisco.setOnClickListener(this);

        estado = findViewById(R.id.btnestado);
        estado.setOnClickListener(this);

        michoacan = findViewById(R.id.btnmichoacan);
        michoacan.setOnClickListener(this);

        morelos = findViewById(R.id.btnmorelos);
        morelos.setOnClickListener(this);

        nayarit = findViewById(R.id.btnnayarit);
        nayarit.setOnClickListener(this);

        nuevoleon = findViewById(R.id.btnnuevoleon);
        nuevoleon.setOnClickListener(this);

        oaxaca = findViewById(R.id.btnoaxaca);
        oaxaca.setOnClickListener(this);

        puebla = findViewById(R.id.btnpuebla);
        puebla.setOnClickListener(this);

        queretaro = findViewById(R.id.btnqueretaro);
        queretaro.setOnClickListener(this);

        quintana = findViewById(R.id.btnquintana);
        quintana.setOnClickListener(this);

        sanluis = findViewById(R.id.btnsanluis);
        sanluis.setOnClickListener(this);

        sinaloa = findViewById(R.id.btnsinaloa);
        sinaloa.setOnClickListener(this);

        sonora = findViewById(R.id.btnsonora);
        sonora.setOnClickListener(this);

        tabasco = findViewById(R.id.btntabasco);
        tabasco.setOnClickListener(this);

        tamaulipas = findViewById(R.id.btntamaulipas);
        tamaulipas.setOnClickListener(this);

        tlaxcala = findViewById(R.id.btntlaxcala);
        tlaxcala.setOnClickListener(this);

        veracruz = findViewById(R.id.btnveracruz);
        veracruz.setOnClickListener(this);

        yucatan = findViewById(R.id.btnyucatan);
        yucatan.setOnClickListener(this);

        zacatecas = findViewById(R.id.btnzacatecas);
        zacatecas.setOnClickListener(this);

        validaPermisos();


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btncdmx:

                Intent intent11zq1e = new Intent(this, Cdmx.class);
                startActivity(intent11zq1e);
                finish();
                break;



            case R.id.btnaguascalientes:

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:449 910 7900"));
                startActivity(intent);

                break;


            case R.id.btnbajacalifornia:

                Intent intent11zq12e = new Intent(this, BajaCalifornia.class);
                startActivity(intent11zq12e);
                finish();
                break;

            case R.id.btnbajacaliforniasur:

                Intent intent11zq12e3 = new Intent(this, BajaCaliforniaSur.class);
                startActivity(intent11zq12e3);
                finish();

                break;

            case R.id.btncampeche:

                Intent intent21 = new Intent(Intent.ACTION_DIAL);
                intent21.setData(Uri.parse("tel:911"));
                startActivity(intent21);

                break;

            case R.id.btncoahuila:

                Intent intent211 = new Intent(Intent.ACTION_DIAL);
                intent211.setData(Uri.parse("tel:91 1"));
                startActivity(intent211);

                break;

            case R.id.btncolima:

                Intent intent213 = new Intent(Intent.ACTION_DIAL);
                intent213.setData(Uri.parse("tel:800 337 2583"));
                startActivity(intent213);
                break;

            case R.id.btnchiapas:


                Intent intent11zq1e3 = new Intent(this, Chiapas.class);
                startActivity(intent11zq1e3);
                finish();
                break;

            case R.id.btnchihu:

                Intent intent21331 = new Intent(Intent.ACTION_DIAL);
                intent21331.setData(Uri.parse("tel:614 4293 300 "));
                startActivity(intent21331);
                break;

            case R.id.btndurango:

                Intent intent11zq1e31 = new Intent(this, Durango.class);
                startActivity(intent11zq1e31);
                finish();

               break;

            case R.id.btnguanajuato:

                Intent intent213311 = new Intent(Intent.ACTION_DIAL);
                intent213311.setData(Uri.parse("tel:800 627 2583"));
                startActivity(intent213311);
                break;

            case R.id.btnguerrero:

                Intent intent2133111 = new Intent(Intent.ACTION_DIAL);
                intent2133111.setData(Uri.parse("tel:747 47 118 63"));
                startActivity(intent2133111);
                break;

            case R.id.btnhidalgo:

                Intent intent21331111 = new Intent(Intent.ACTION_DIAL);
                intent21331111.setData(Uri.parse("tel:771 719 4500"));
                startActivity(intent21331111);
                break;

            case R.id.btnjalisco:

                Intent intent213311111 = new Intent(Intent.ACTION_DIAL);
                intent213311111.setData(Uri.parse("tel:333 823 3220"));
                startActivity(intent213311111);
                break;

            case R.id.btnestado:

                Intent intent2133111111 = new Intent(Intent.ACTION_DIAL);
                intent2133111111.setData(Uri.parse("tel:800 900 3200"));
                startActivity(intent2133111111);
                break;

            case R.id.btnmichoacan:

                Intent intent21331111111 = new Intent(Intent.ACTION_DIAL);
                intent21331111111.setData(Uri.parse("tel:800 123 2890"));
                startActivity(intent21331111111);
                break;

            case R.id.btnmorelos:

                Intent intent213311111111 = new Intent(Intent.ACTION_DIAL);
                intent213311111111.setData(Uri.parse("tel:777 314  3336"));
                startActivity(intent213311111111);
                break;

            case R.id.btnnayarit:

                Intent intent2133111111111 = new Intent(Intent.ACTION_DIAL);
                intent2133111111111.setData(Uri.parse("tel: 311 217 9556"));
                startActivity(intent2133111111111);
                break;

            case R.id.btnnuevoleon:
                Intent intent11zq1e3q = new Intent(this, NuevoLeon.class);
                startActivity(intent11zq1e3q);
                finish();

                break;

            case R.id.btnoaxaca:
                Intent intent11zq1e32 = new Intent(this, Oaxaca.class);
                startActivity(intent11zq1e32);
                finish();
                break;

            case R.id.btnpuebla:

                Intent intent21331111111111 = new Intent(Intent.ACTION_DIAL);
                intent21331111111111.setData(Uri.parse("tel: 800 420 5782"));
                startActivity(intent21331111111111);
                break;

            case R.id.btnqueretaro:

                Intent intent21331111111112 = new Intent(Intent.ACTION_DIAL);
                intent21331111111112.setData(Uri.parse("tel:442 101 5205"));
                startActivity(intent21331111111112);
                break;

            case R.id.btnquintana:

                Intent intent22 = new Intent(Intent.ACTION_DIAL);
                intent22.setData(Uri.parse("tel: 800 832 9198"));
                startActivity(intent22);

                break;

            case R.id.btnsanluis:

                Intent intent222 = new Intent(Intent.ACTION_DIAL);
                intent222.setData(Uri.parse("tel: 800 123 8888"));
                startActivity(intent222);

                break;

            case R.id.btnsinaloa:

                Intent intent2222 = new Intent(Intent.ACTION_DIAL);
                intent2222.setData(Uri.parse("tel:667 713 0063"));
                startActivity(intent2222);

                break;

            case R.id.btnsonora:

                Intent intent22222 = new Intent(Intent.ACTION_DIAL);
                intent22222.setData(Uri.parse("tel: 662 216 2759"));
                startActivity(intent22222);

                break;

            case R.id.btntabasco:

                Intent intent222222 = new Intent(Intent.ACTION_DIAL);
                intent222222.setData(Uri.parse("tel: 800 624 1774"));
                startActivity(intent222222);

                break;

          case R.id.btntamaulipas:

              Intent intent11zq1e31d = new Intent(this, Tamaulipas.class);
              startActivity(intent11zq1e31d);
              finish();

            break;

            case R.id.btntlaxcala:

                Intent intent2222222 = new Intent(Intent.ACTION_DIAL);
                intent2222222.setData(Uri.parse("tel:9 1 1"));
                startActivity(intent2222222);

                break;

            case R.id.btnveracruz:

                Intent intent22222222 = new Intent(Intent.ACTION_DIAL);
                intent22222222.setData(Uri.parse("tel: 800 123 456"));
                startActivity(intent22222222);

                break;

            case R.id.btnyucatan:

                Intent intent222222222 = new Intent(Intent.ACTION_DIAL);
                intent222222222.setData(Uri.parse("tel:800 982 28 26"));
                startActivity(intent222222222);

                break;

            case R.id.btnzacatecas:

                Intent intent2222222222 = new Intent(Intent.ACTION_DIAL);
                intent2222222222.setData(Uri.parse("tel:8009672583"));
                startActivity(intent2222222222);

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
            AlertDialog.Builder dialogo = new AlertDialog.Builder(TelefonosMexico.this);
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
            startActivity(new Intent(getBaseContext(), MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.telefonos, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(getBaseContext(), MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                finish();
                break;

            case R.id.pemex:

                Intent intent11zq1e3q = new Intent(this, Pemex.class);
                startActivity(intent11zq1e3q);
                finish();

                break;

            case R.id.issste:
                Intent intent222 = new Intent(Intent.ACTION_DIAL);
                intent222.setData(Uri.parse("tel:55 4000 1000"));
                startActivity(intent222);

                break;

        }


        return super.onOptionsItemSelected(item);
    }
}