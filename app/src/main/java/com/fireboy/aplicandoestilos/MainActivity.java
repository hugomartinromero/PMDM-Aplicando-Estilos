package com.fireboy.aplicandoestilos;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgColores;
    CheckBox cbNegrita, cbCursiva;
    TextView lblPrueba;
    SwitchCompat swcOscuro, swcLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgColores = findViewById(R.id.rgColores);
        cbNegrita = findViewById(R.id.cbNegrita);
        cbCursiva = findViewById(R.id.cbCursiva);
        lblPrueba = findViewById(R.id.lblPrueba);
        swcOscuro = findViewById(R.id.swcOscuro);
        swcLog = findViewById(R.id.swcLog);

        rgColores.setOnCheckedChangeListener((radioGroup, i) -> cambiarColor(rgColores.getCheckedRadioButtonId()));
        cbNegrita.setOnCheckedChangeListener((compoundButton, b) -> cambiarEstilos());
        cbCursiva.setOnCheckedChangeListener((compoundButton, b) -> cambiarEstilos());
        swcOscuro.setOnCheckedChangeListener((compoundButton, b) -> modoOscuro());
    }

    private void cambiarColor(int id) {
        if (id == R.id.rbRojo) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO COLOR", "COLOR DEL TEXTO: ROJO");
            }

            lblPrueba.setTextColor(Color.RED);
        } else if (id == R.id.rbVerde) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO COLOR", "COLOR DEL TEXTO: VERDE");
            }

            lblPrueba.setTextColor(Color.GREEN);
        } else if (id == R.id.rbAzul) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO COLOR", "COLOR DEL TEXTO: AZUL");
            }

            lblPrueba.setTextColor(Color.BLUE);
        }
    }

    private void cambiarEstilos() {
        int estilo = Typeface.NORMAL;

        if (cbNegrita.isChecked() && cbCursiva.isChecked()) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO ESTILO", "ESTILO DEL TEXTO: NEGRITA Y CURSIVA");
            }

            estilo = Typeface.BOLD_ITALIC;
        } else if (cbNegrita.isChecked()) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO ESTILO", "ESTILO DEL TEXTO: NEGRITA");
            }

            estilo = Typeface.BOLD;
        } else if (cbCursiva.isChecked()) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO ESTILO", "ESTILO DEL TEXTO: CURSIVA");
            }

            estilo = Typeface.ITALIC;
        } else {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO ESTILO", "ESTILO DEL TEXTO: NORMAL");
            }
        }

        lblPrueba.setTypeface(null, estilo);
    }

    private void modoOscuro() {
        if (swcOscuro.isChecked()) {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO MODO", "MODO OSCURO");
            }

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            if (swcLog.isChecked()) {
                Log.i("CAMBIO MODO", "MODO CLARO");
            }

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}