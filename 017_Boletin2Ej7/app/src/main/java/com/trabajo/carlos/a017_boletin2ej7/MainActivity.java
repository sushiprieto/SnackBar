package com.trabajo.carlos.a017_boletin2ej7;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edt1, edt2;
    private Button btnOk;
    private TextView txvResultado;
    private LinearLayout linear;
    private RadioButton rdbMas, rdbMenos, rdbPor, rdbEntre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btnOk = (Button) findViewById(R.id.btnOk);
        txvResultado = (TextView) findViewById(R.id.txvResultado);
        rdbMas = (RadioButton) findViewById(R.id.rdbMas);
        rdbMenos = (RadioButton) findViewById(R.id.rdbMenos);
        rdbPor = (RadioButton) findViewById(R.id.rdbPor);
        rdbEntre = (RadioButton) findViewById(R.id.rdbEntre);
        linear = findViewById(R.id.linear);

        btnOk.setOnClickListener(this);
        rdbMas.setOnClickListener(this);
        rdbMenos.setOnClickListener(this);
        rdbPor.setOnClickListener(this);
        rdbEntre.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int num1, num2;
        double resultado = 0;

        num1 = Integer.parseInt(edt1.getText().toString());
        num2 = Integer.parseInt(edt2.getText().toString());

        switch (view.getId()) {

            case R.id.rdbMas:
                resultado = num1 + num2;

                txvResultado.setText("" + resultado);

                break;

            case R.id.rdbMenos:
                resultado = num1 - num2;

                txvResultado.setText("" + resultado);

                break;

            case R.id.rdbPor:
                resultado = num1 * num2;

                txvResultado.setText("" + resultado);

                break;

            case R.id.rdbEntre:

                if (num2 == 0) {

                    Snackbar snackbar = Snackbar.make(linear, "No se puede dividir entre 0", Snackbar.LENGTH_LONG)
                            .setAction("SUSTIRUIR", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    edt2.setText("1");

                                }
                            });
                    snackbar.show();

                } else {
                    resultado = num1 / num2;
                }


                txvResultado.setText("" + resultado);

                break;
        }
    }
}
