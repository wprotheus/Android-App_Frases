package com.wprotheus.aulafrasesdodia;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvFrase;
    private String[] frases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvFrase = findViewById(R.id.tvFrase);
        frases = getResources().getStringArray(R.array.frases);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gerarFrase(View view) {
        tvFrase.setText(frases[new Random().nextInt(frases.length)]);
    }

    public void mostrarFrases(View view) {
        StringBuilder todasFrases = new StringBuilder();
        for (String frase : frases)
            todasFrases.append(frase).append("\n");
        tvFrase.setText(todasFrases.toString());
    }
}