package com.univalle.fastfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.univalle.fastfood.Model.Persona;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.univalle.fastfood.Model.Persona;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RegistroP extends AppCompatActivity {

    EditText Correo_ElectronicoID, contraseña, nombre, apellidos;
    Button botonRegistrarse;
    TextView IniciarSesion;
    FirebaseAuth mFirebaseAuth;
    Button botonRegresar;

    //crud base de datos
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //colecciones
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_p);

        mFirebaseAuth = FirebaseAuth.getInstance();
        Correo_ElectronicoID = findViewById(R.id.editTextTextPersonName5);
        contraseña = findViewById(R.id.editTextTextPassword2);
        botonRegistrarse = findViewById(R.id.button2);
        botonRegresar = findViewById(R.id.button5);

        nombre = findViewById(R.id.editTextTextPersonName2);
        apellidos = findViewById(R.id.editTextTextPersonName4);

        inicializarFirebase();

        fStore = FirebaseFirestore.getInstance();

        botonRegistrarse.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String Correo_Electronico = Correo_ElectronicoID.getText().toString();
                String Contraseña = contraseña.getText().toString();

                String Nombre = nombre.getText().toString();
                String Apellidos = apellidos.getText().toString();


                if(Correo_Electronico.isEmpty()){
                    Correo_ElectronicoID.setError("Por favor ingresa el Correo Electronico");
                    Correo_ElectronicoID.requestFocus();
                }
                else if (Contraseña.isEmpty()){
                    contraseña.setError("Por favor ingresa la Contraseña");
                    contraseña.requestFocus();
                }
                else if (Correo_Electronico.isEmpty() && Contraseña.isEmpty()){
                    Toast.makeText(RegistroP.this,"Los campos están vacios",Toast.LENGTH_SHORT).show();
                }
                else if(!(Correo_Electronico.isEmpty() && Contraseña.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(Correo_Electronico,Contraseña).addOnCompleteListener(RegistroP.this, new OnCompleteListener<AuthResult>() { //aqui registra el correo y la contraseña

                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) { //aqui configuro es el redireccionamiento a la otra ventana
                            if(!task.isSuccessful()){
                                Toast.makeText(RegistroP.this,"Error, el Registro no se pudo Completar, intentalo nuevamente",Toast.LENGTH_SHORT).show();

                            }
                            else{

                                //CRUD AGREGAR a la base de datos
                                Persona person = new Persona();
                                person.setCorreo_Electronico(Correo_Electronico);
                                person.setContraseña(Contraseña);
                                person.setNombre(Nombre);
                                person.setApellidos(Apellidos);
                                person.setU_id(UUID.randomUUID().toString());
                                databaseReference.child("Usuarios_Registrados").child(person.getU_id()).setValue(person);

                                //Colecciones Firebase Usuario registrado:
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                DocumentReference df = fStore.collection("Usuarios Registrados").document(user.getUid());
                                Map<String,Object> userInfo = new HashMap<>();
                                userInfo.put("Nombre", Nombre);
                                userInfo.put("Apellidos", Apellidos);
                                userInfo.put("Correo_Electronico", Correo_Electronico);
                                userInfo.put("Contraseña", Contraseña);
                                //userInfo.put("Cliente", "1"); No la voy a utilizar ya que todos son clientes
                                df.set(userInfo);

                                startActivity(new Intent(RegistroP.this, MainActivity.class)); //aqui me redirecciono a la otra ventana


                            }
                        }
                    });



                }
                else{
                    Toast.makeText(RegistroP.this,"Se produjo un error!",Toast.LENGTH_SHORT).show();
                }


            }





        });



        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroP.this, Registro1.class);
                startActivity(i);
            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance(FirebaseApp.getInstance());
        databaseReference = firebaseDatabase.getReference();
    }


}