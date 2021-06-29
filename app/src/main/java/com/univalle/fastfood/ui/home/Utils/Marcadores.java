package com.univalle.fastfood.ui.home.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.univalle.fastfood.R;

public class Marcadores {

    GoogleMap nMap;
    Context context;

    public Marcadores(GoogleMap nMap, Context context){
        this.nMap = nMap;
        this.context = context;

    }

    public void addMarkersDefault(){

        uno(3.0052374, -76.4833395,"uno, Parque");

        dos(3.0067319, -76.4863687, "Dos, Galeria");
        tres(3.0063079, -76.4861954, "Tres, Restaurante Micomida");
        cuatro(3.0032472, -76.4807786,"Cuatro, Sofis shoes");
        cinco(3.0063685, -76.4784648, "Cinco, Casa Blanca");
        seis(3.0212427, -76.4814888, "Seis, Univalle");

    }

    public void uno(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("uno")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }

    public void dos(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("dos")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void tres(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("tres")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cuatro(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("cuatro")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void cinco(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("cinco")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }
    public void seis(Double latitud, Double logintud, String titulo){

        LatLng punto = new LatLng(latitud,logintud);
        int heigth=140;
        int width= 165;
        BitmapDrawable uno= (BitmapDrawable) context.getResources().getDrawable(R.drawable.mipuntr2);
        Bitmap unos = uno.getBitmap();
        Bitmap uns = Bitmap.createScaledBitmap(unos, width, heigth, false);
        nMap.addMarker(new MarkerOptions()
                .position(punto)
                .title(titulo).snippet("seis")
                .icon(BitmapDescriptorFactory.fromBitmap(uns)));

    }


}
