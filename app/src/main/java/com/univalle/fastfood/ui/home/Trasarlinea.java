package com.univalle.fastfood.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.univalle.fastfood.R;
import com.univalle.fastfood.ui.home.Utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trasarlinea extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap nMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        nMap = googleMap;

        /*
        if (ActivityCompat.checkSelfPermission(Trasarlinea.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Trasarlinea.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(Trasarlinea.this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(Trasarlinea.this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

            if (ActivityCompat.shouldShowRequestPermissionRationale(Trasarlinea.this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(Trasarlinea.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }




            return;
        }

         */
        nMap.setMyLocationEnabled(true);
        nMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        Utils.markersDefault(nMap,getApplicationContext());

        ArrayList<LatLng>points=null;
        PolylineOptions lineOptions=null;


        for(int i = 0; i< Utils.routes.size(); i++){
            Log.d("aqui", String.valueOf(Utils.routes.size()));
            points = new ArrayList<LatLng>();
            lineOptions = new PolylineOptions();


            List<HashMap<String, String>> path = Utils.routes.get(i);


            for(int j=0;j<path.size();j++){
                HashMap<String,String> point = path.get(j);

                double lat = Double.parseDouble(point.get("lat"));
                double lng = Double.parseDouble(point.get("lng"));
                LatLng position = new LatLng(lat, lng);

                points.add(position);
            }


            lineOptions.addAll(points);

            lineOptions.width(14);

            lineOptions.color(Color.RED);
        }

        nMap.addPolyline(lineOptions);

        LatLng destino = new LatLng(Utils.coordenadas.getDestinoLat(), Utils.coordenadas.getDestinoLng());
        //LatLng destino = new LatLng(3.0212427, -76.4814888);

        nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(destino, 16));


    }



}