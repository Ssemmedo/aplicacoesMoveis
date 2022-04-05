package com.example.gasolinavsetanol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtEtanol, edtGasolina;
    TextView txtResultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregaComponentes();

        btnCalcular.setOnClickListener(view -> {
            double percentagem;
            double etanol;
            double gasolina;
            String resultado;

            gasolina = Double.parseDouble(edtGasolina.getText().toString());
            etanol = Double.parseDouble(edtEtanol.getText().toString());
            percentagem = (gasolina*0.7);

            if(percentagem<=etanol) resultado = "É melhor colocar etanol";
            else if(percentagem>etanol) resultado = "É melhor colocar gasolina";
            else resultado = "Não foi possivel ter um repsosta";

            txtResultado.setText(resultado);

            edtEtanol.setText("");
            edtGasolina.setText("");
            edtGasolina.requestFocus();
            edtEtanol.requestFocus();
        });
    }

    void carregaComponentes(){
        edtEtanol = findViewById(R.id.edtEtanol);
        edtGasolina = findViewById(R.id.edtGasolina);
        btnCalcular = findViewById(R.id.btnCalc);
        txtResultado = findViewById(R.id.resultado);
    }

}