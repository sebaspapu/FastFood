package com.univalle.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.univalle.fastfood.ui.home.MapaInicio;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback , NavigationView.OnNavigationItemSelectedListener {

    SupportMapFragment supportMapFragment;

    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportMapFragment = SupportMapFragment.newInstance();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                 */
                Intent inToLogin2 = new Intent(getApplication(), MapaInicio.class);
                startActivity(inToLogin2);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        supportMapFragment.getMapAsync(this);


        //ITEM SELECTED MENU

        /*
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar , "Open navigation drawer","Close navigation drawer");
        drawer.addDrawerListener(toggle);
        toggle.syncState();
         */

        NavigationView navigationView1 = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.logout){

            FirebaseAuth.getInstance().signOut();

            Intent inToLogin = new Intent(MainActivity.this, Login.class);
            startActivity(inToLogin);
            return true;

        }else if (id == R.id.nav_home2) {

                Intent inToLogin2 = new Intent(getApplication(), MapaInicio.class);
                startActivity(inToLogin2);
            return true;

        }else if (id == R.id.nav_slideshow) {

            Intent inToLogin3 = new Intent(getApplication(), Pruebaxd.class);
            startActivity(inToLogin3);
            return true;

        }
        /*else if (id == R.id.nav_home) {

            Intent inToLogin2 = new Intent(getApplication(), HomeViewModel.class);
            startActivity(inToLogin2);


        }

         */





        return false;

    }



}



