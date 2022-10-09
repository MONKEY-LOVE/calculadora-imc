package com.example.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class inicioActivity extends AppCompatActivity {
    EditText txtestatura;
    EditText txtpeso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        txtestatura = findViewById(R.id.txtestatura);
        txtpeso = findViewById(R.id.txtpeso);

    }
    public void imc(View vista){
        String texto1 = txtestatura.getText().toString();
        String texto2 = txtpeso.getText().toString();
        if (texto1.equals("") || texto2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Llene todos los datos", Toast.LENGTH_SHORT).show();
        }else{
            float txtestatura = Integer.parseInt(texto1);
            float txtpeso = Integer.parseInt(texto2);
            txtestatura = txtestatura/100;
            float imc=txtpeso/(float) Math.pow(txtestatura,2);
            String imcTexto= String.format("%.1f", imc);
            if (imc <18.5f)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Bajo peso ", Toast.LENGTH_SHORT).show();
            if (imc >= 18.5f && imc < 24.9f)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Peso normal ", Toast.LENGTH_SHORT).show();
            if (imc >= 25 && imc < 29)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Sobre peso ", Toast.LENGTH_SHORT).show();
            if (imc >= 30 && imc < 34)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Obesidad Grado 1 ", Toast.LENGTH_SHORT).show();
            if (imc >= 35 && imc < 39)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Obesidad Grado 2 ", Toast.LENGTH_SHORT).show();
            if (imc >= 40)
                Toast.makeText(getApplicationContext(), "Su IMC es: "+ imcTexto + "Obesidad Grado 3 ", Toast.LENGTH_SHORT).show();
        }
    }
}