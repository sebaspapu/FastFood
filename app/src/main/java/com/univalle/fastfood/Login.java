package com.univalle.fastfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText Correo_ElectronicoID, contraseña;
    Button botonIniciarSesion;
    Button botonRegistrarse;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Correo_ElectronicoID = findViewById(R.id.editTextTextPersonName);
        contraseña = findViewById(R.id.editTextTextPassword);
        botonIniciarSesion = findViewById(R.id.button);
        botonRegistrarse = findViewById(R.id.button2);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

                if(mFirebaseUser != null){

                    Toast.makeText(Login.this, "Iniciaste sesion", Toast.LENGTH_SHORT); //estoy logueado
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);

                    /*
                    boolean verifica = (boolean) true;

                    MainActivity objeto = new MainActivity();


                    if(objeto.onNavigationItemSelected(null) == verifica){
                        verifica = false;

                        Toast.makeText(Login.this, "Por favor inicia sesion de nuevo", Toast.LENGTH_SHORT);

                    }
                     */

                }
                else {
                    Toast.makeText(Login.this, "Por favor inicia sesion", Toast.LENGTH_SHORT);
                }
            }
        };

        botonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Correo_Electronico = Correo_ElectronicoID.getText().toString();
                String Contraseña = contraseña.getText().toString();

                if(Correo_Electronico.isEmpty()){
                    Correo_ElectronicoID.setError("Por favor ingresa el Correo Electronico");
                    Correo_ElectronicoID.requestFocus();
                }
                else if (Contraseña.isEmpty()){
                    contraseña.setError("Por favor ingresa la Contraseña");
                    contraseña.requestFocus();
                }
                else if (Correo_Electronico.isEmpty() && Contraseña.isEmpty()){
                    Toast.makeText(Login.this,"Los campos están vacios",Toast.LENGTH_SHORT).show();
                }
                else if(!(Correo_Electronico.isEmpty() && Contraseña.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(Correo_Electronico,Contraseña).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(Login.this,"Error de inicio, intenta Iniciar sesión nuevamente!",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intToMenuPrincipal = new Intent(Login.this , MainActivity.class);
                                startActivity(intToMenuPrincipal);
                            }
                        }
                    });

                }
                else{
                    Toast.makeText(Login.this,"Se produjo un error!",Toast.LENGTH_SHORT).show();
                }

            }
        });

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToRegistrar = new Intent(Login.this, Registro1.class);
                startActivity(intToRegistrar);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }



}