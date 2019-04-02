package com.example.practica3intentsapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDatos = findViewById(R.id.tvDatos);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                ArrayList<String> pedido = intent.getStringArrayListExtra(Intent.EXTRA_TEXT);

                for (String comida : pedido) {
                    tvDatos.append(comida);
                    tvDatos.append("\n");
                }
            }
        }

    }
}
