package com.example.calculador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove,
            ponto, igual, soma, subtracao, divisao, multipiccao, parenteses, virgula, apagar, porcentagem;

    private TextView txtExpressao, txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarcomponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multipiccao.setOnClickListener(this);
        soma.setOnClickListener(this);
        porcentagem.setOnClickListener(this);
        ponto.setOnClickListener(this);
        virgula.setOnClickListener(this);
        parenteses.setOnClickListener(this);
       // igual.setOnClickListener(this);

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double) longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });





    }

    private void iniciarcomponentes() {
        numeroZero = findViewById(R.id.bt_zero);
        numeroUm = findViewById(R.id.bt_um);
        numeroDois = findViewById(R.id.bt_dois);
        numeroTres = findViewById(R.id.bt_tres);
        numeroQuatro = findViewById(R.id.bt_quatro);
        numeroCinco = findViewById(R.id.bt_cinco);
        numeroSeis = findViewById(R.id.bt_seis);
        numeroSete = findViewById(R.id.bt_sete);
        numeroOito = findViewById(R.id.bt_oito);
        numeroNove = findViewById(R.id.bt_nove);
        ponto = findViewById(R.id.bt_ponto);
        igual = findViewById(R.id.bt_igual);
        virgula = findViewById(R.id.bt_virgula);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        multipiccao = findViewById(R.id.bt_mutiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        porcentagem = findViewById(R.id.bt_porcento);
        parenteses = findViewById(R.id.bt_parenteses);
        apagar = findViewById(R.id.bt_limpar);

    }

    public void AcrecentarUmaExpressao(String string, boolean limpar_dados) {

        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }
        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtResultado.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zero:
                AcrecentarUmaExpressao("0", true);
                break;
            case R.id.bt_um:
                AcrecentarUmaExpressao("1", true);
                break;
            case R.id.bt_dois:
                AcrecentarUmaExpressao("2", true);
                break;
            case R.id.bt_tres:
                AcrecentarUmaExpressao("3", true);
                break;
            case R.id.bt_quatro:
                AcrecentarUmaExpressao("4", true);
                break;
            case R.id.bt_cinco:
                AcrecentarUmaExpressao("5", true);
                break;
            case R.id.bt_seis:
                AcrecentarUmaExpressao("6", true);
                break;
            case R.id.bt_sete:
                AcrecentarUmaExpressao("7", true);
                break;
            case R.id.bt_oito:
                AcrecentarUmaExpressao("8", true);
                break;
            case R.id.bt_nove:
                AcrecentarUmaExpressao("9", true);
                break;
            case R.id.bt_soma:
                AcrecentarUmaExpressao("+", true);
                break;
            case R.id.bt_mutiplicacao:
                AcrecentarUmaExpressao("*", true);
                break;
            case R.id.bt_divisao:
                AcrecentarUmaExpressao("/", true);
                break;
            case R.id.bt_subtracao:
                AcrecentarUmaExpressao("-", true);
                break;
            case R.id.bt_ponto:
                AcrecentarUmaExpressao(".", true);
                break;
            case R.id.bt_virgula:
                AcrecentarUmaExpressao(",", true);
                break;
            case R.id.bt_porcento:
                AcrecentarUmaExpressao("%", true);
                break;
            case R.id.bt_parenteses:
                AcrecentarUmaExpressao("( ", true);
                AcrecentarUmaExpressao(" )", true);
                break;
            case R.id.bt_igual:
                AcrecentarUmaExpressao("=", true);
                break;


        }
    }
}

