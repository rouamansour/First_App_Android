package com.example.conversiontemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edc , edf ;
    private Button btnFC , btnCF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ecouteurs();

    }

    public void init(){
        edc=findViewById(R.id.edc);
        edf=findViewById(R.id.edf);
        btnCF=findViewById(R.id.btnCF);
        btnFC=findViewById(R.id.btnFC);
    }

    private void ecouteurs() {
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertirDC_FC();
            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertirDF_DC();
            }
        });
        // listener permet de convertir lorsque entrer sur un chiffre
        edc.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                convertirDC_FC();
                return false;
            }
        });

        edf.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                convertirDF_DC();
                return false;
            }
        });
    }

    private void convertirDF_DC() {
        try{
            float f=Float.parseFloat(edf.getText().toString());
            float c=(f-32)*5/9;
            edc.setText(c+"");
            colorer();
        } catch (NumberFormatException e) {
            edc.setText("nombre invalide");
        }

    }

    private void convertirDC_FC() {
        try{
            float c=Float.parseFloat(edc.getText().toString());
            float f= (c*9)/5+32;
            edf.setText(f+"");
            colorer();

        } catch (NumberFormatException e) {
            edf.setText("nombre invalide");
        }
    }

    private void colorer() {
        float c=Float.parseFloat(edc.getText().toString());
        if (c <= 0) {
            edc.setTextColor(Color.WHITE);
            edc.setBackgroundColor(Color.BLACK);
            edf.setTextColor(Color.WHITE);
            edf.setBackgroundColor(Color.BLACK);
        } else if (c <= 20) {
            edc.setTextColor(Color.BLUE);
            edc.setBackgroundColor(Color.WHITE);
            edf.setTextColor(Color.BLUE);
            edf.setBackgroundColor(Color.WHITE);
        } else if (c <= 30) {
            edc.setTextColor(Color.YELLOW);
            edc.setBackgroundColor(Color.GREEN);
            edf.setTextColor(Color.YELLOW);
            edf.setBackgroundColor(Color.GREEN);
        } else {
            edc.setTextColor(Color.RED);
            edc.setBackgroundColor(Color.GRAY);
            edf.setTextColor(Color.RED);
            edf.setBackgroundColor(Color.GRAY);
        }

    }


}