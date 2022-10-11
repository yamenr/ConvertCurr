package com.example.convertcurr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etCurrency;
    private Button btnCalc;
    private Spinner spn1, spn2;
    private TextView result;
    private ImageView img , img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectComponents();
    }

    private void connectComponents() {

        etCurrency = findViewById(R.id.etCurrencyMain);
        btnCalc = findViewById(R.id.btnCalcMain);
        spn1 = findViewById(R.id.spnMain);
        spn2 = findViewById(R.id.spnMain2);
        result = findViewById(R.id.tvResultMain);
        img = findViewById(R.id.ivMain);
        img2 = findViewById(R.id.ivMain2);


    }


    public void Calculate(View view) {
        String currency = etCurrency.getText().toString();
        String s1 = spn1.getSelectedItem().toString();
        String s2 = spn2.getSelectedItem().toString();

        if (currency.isEmpty())
            Toast.makeText(this, "There is no currency value", Toast.LENGTH_LONG).show();

        if (s1.equals(s2))
            Toast.makeText(this, "cannot convert to same currency", Toast.LENGTH_LONG).show();

        double c = Double.parseDouble(currency);
        if (s1.equals("Dollar") && s2.equals("Shekel")) {

            img.setImageResource(R.drawable.dollar);
            img2.setImageResource(R.drawable.shekel);



            Toast.makeText(this, "result : " + (c * 3.56), Toast.LENGTH_LONG).show();

            result.setText("" + (c * 3.56));

        } else if (s1.equals("Shekel") && s2.equals("Dollar")) {

            img.setImageResource(R.drawable.shekel);
            img2.setImageResource(R.drawable.dollar);

            Toast.makeText(this, "result : " + (c / 3.56), Toast.LENGTH_LONG).show();

            result.setText("" + (c / 3.56));

        }
    }
}