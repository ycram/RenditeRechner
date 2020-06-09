package de.arvidortwig.renditerechner;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc = (Button) findViewById(R.id.calc);


        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText groesse_m2 = (EditText) findViewById(R.id.editTextNumber_groesse_m2);
                EditText kaltmiete_m2 = (EditText) findViewById(R.id.editTextNumber_kaltmiete_m2);
                TextView kaltmiete_gesamt = (TextView) findViewById(R.id.textView_kaltmiete_gesamt);

                int int_groesse_m2=Integer.parseInt(groesse_m2.getText().toString());
                int int_kaltmiete_m2=Integer.parseInt(kaltmiete_m2.getText().toString());
                int int_kaltmiete_gesamt=int_groesse_m2*int_kaltmiete_m2;
                kaltmiete_gesamt.setText(Integer.toString(int_kaltmiete_gesamt));
            }

        });

    }
}