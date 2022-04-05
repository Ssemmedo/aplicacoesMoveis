package com.example.imccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso;
    EditText edtAltura;
    Button btnCalcular;
    TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregaComponentes();
        configuraBotãoCalcular();
    }

    protected void carregaComponentes(){
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
    }

    protected void configuraBotãoCalcular(){
        btnCalcular.setOnClickListener(view -> {
            String resultado = realizaCalculo();
            exibeResultado(resultado);
            limpaCampos();
        });
    }

    protected String realizaCalculo(){
        float peso = Float.parseFloat(edtPeso.getText().toString());
        float altura = Float.parseFloat(edtAltura.getText().toString());
        float resultado = peso/(altura*2);
        if(resultado<16) return "Magreza grave";
        if(resultado>=16 && resultado<17) return "Magreza moderada";
        if(resultado>=17 && resultado<18.5) return "Magreza Leve";
        if(resultado>=18.5 && resultado<25) return "Saudável";
        if(resultado>=25 && resultado<30) return "Sobrepeso";
        if(resultado>=30 && resultado<35) return "Obesidade Grau I";
        if(resultado>=35 && resultado<40) return "Obesidade Grau II";
        if(resultado>=40) return "Obesidade Grau III (morbida)";
        return "Indefinido";
    }

    protected void exibeResultado(String resultado){
        txtResultado.setText(resultado);
    }

    protected void limpaCampos(){
        edtPeso.setText("");
        edtAltura.setText("");
        edtPeso.requestFocus();
        edtAltura.requestFocus();
    }
}