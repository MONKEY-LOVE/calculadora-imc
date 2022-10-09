package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaluacion.modelo.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText et_correo, et_contrasena;
    private Button btn_iniciar_sesion;

    private ArrayList<Usuario> listaUsuario;
    private Usuario objUsuario;
    int intentos = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ini();

    }
    public void ini()
    {
        et_correo = (EditText) findViewById(R.id.et_correo);
        et_contrasena = (EditText) findViewById(R.id.et_contrasena);
        btn_iniciar_sesion = (Button) findViewById(R.id.btn_iniciar_sesion);
        btn_iniciar_sesion.setOnClickListener(this);
    }

    private void llenarUsuario()
    {
        listaUsuario = new ArrayList<Usuario>();
        listaUsuario.add(new Usuario("Hugo","Aguilera","Hugo","1234"));
    }

    private void iniciarSesion()
    {
        llenarUsuario();
        String correo = et_correo.getText().toString();
        String contrasena = et_contrasena.getText().toString();
        boolean usuarioEncontrado=false;

        for (int i =0; i< listaUsuario.size(); i++)
        {
            if (correo.equals(listaUsuario.get(i).getCorreo()) && contrasena.equals(listaUsuario.get(i).getContrasena()))
            {
                Toast.makeText(this, "Bienvenido " + listaUsuario.get(i).getNombre(), Toast.LENGTH_SHORT).show();
                usuarioEncontrado = true;
                Intent inicio = new Intent(MainActivity.this, inicioActivity.class);
                startActivity(inicio);
            }
            else if (correo.isEmpty() || contrasena.isEmpty())
            {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
        if (!usuarioEncontrado)
        {
            if (intentos > 0) {
                Toast.makeText(this, "Te quedan intentos: " + intentos, Toast.LENGTH_SHORT).show();
                intentos -= 1;

            } else {
                finishAffinity();
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_iniciar_sesion)
        {
            iniciarSesion();
        }
    }
}