package de.arvidortwig.renditerechner;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calc = (Button) findViewById(R.id.calc);
        final Switch monatjahr = (Switch) findViewById(R.id.switch1_monat_jahr);




        calc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Berechnung der Kaltmiete

                EditText groesse_m2 = (EditText) findViewById(R.id.editTextNumber_groesse_m2);
                EditText kaltmiete_m2 = (EditText) findViewById(R.id.editTextNumber_kaltmiete_m2);
                TextView kaltmiete_gesamt_ergebnis = (TextView) findViewById(R.id.textView_kaltmiete_gesamt_ergebnis);
                EditText nebenkosten = (EditText) findViewById(R.id.editTextNumber_Nebenkosten);
                EditText nebenkosten_prozent = (EditText) findViewById(R.id.editTextNumber_Nebenkosten_prozent);
                EditText stellplatz = (EditText) findViewById(R.id.editTextNumber_Stellplatz);
                EditText grundsteuer = (EditText) findViewById(R.id.editTextNumber_Grundsteuer);
                TextView einnahmen = (TextView) findViewById(R.id.textView_Einnahmen);

                int int_groesse_m2,int_kaltmiete_m2,int_nebenkosten,int_nebenkosten_prozent,int_stellplatz,int_grundsteuer,int_kaltmiete_gesamt,int_einnahmen;

                int_groesse_m2=Integer.parseInt(groesse_m2.getText().toString());
                int_kaltmiete_m2=Integer.parseInt(kaltmiete_m2.getText().toString());
                int_nebenkosten=Integer.parseInt(nebenkosten.getText().toString());
                int_nebenkosten_prozent=Integer.parseInt(nebenkosten_prozent.getText().toString());
                int_stellplatz=Integer.parseInt(stellplatz.getText().toString());
                int_grundsteuer=Integer.parseInt(grundsteuer.getText().toString());


                int_kaltmiete_gesamt=int_groesse_m2*int_kaltmiete_m2;
                int_einnahmen=int_kaltmiete_gesamt+int_stellplatz-int_grundsteuer-(int_nebenkosten-(int_nebenkosten*int_nebenkosten_prozent/100));

                //kaltmiete_gesamt_ergebnis.setText(Integer.toString(int_kaltmiete_gesamt));
                //einnahmen.setText(Integer.toString((int_einnahmen)));


                        if(monatjahr.getText().toString().equals("on"))
                        {
                            int_kaltmiete_gesamt= int_kaltmiete_gesamt*12;
                            int_einnahmen =  int_einnahmen*12;
                            kaltmiete_gesamt_ergebnis.setText(Integer.toString(int_kaltmiete_gesamt));
                            einnahmen.setText(Integer.toString((int_einnahmen)));

                        }

                        else if(monatjahr.getText().toString().equals("off"))
                        {
                            kaltmiete_gesamt_ergebnis.setText(Integer.toString(int_kaltmiete_gesamt));
                            einnahmen.setText(Integer.toString((int_einnahmen)));
                        }

            }

        });

    }
}