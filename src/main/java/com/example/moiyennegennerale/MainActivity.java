package com.example.moiyennegennerale;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.moiyennegennerale.R;

public class MainActivity extends AppCompatActivity {

    private EditText tpView;
    //Cette ligne déclare une variable tpView qui sera utilisée pour référencer un champ de saisie où l'utilisateur pourra entrer les notes relatives aux Travaux Pratiques (TP)
    private EditText tdView;
    //Cette ligne déclare une variable tdView destinée à représenter un champ de saisie où l'utilisateur pourra entrer les notes correspondant aux Travaux Dirigés (TD).
    private EditText emdView;
    //Cette déclaration crée un objet emdView, qui sera utilisé pour faire référence à un champ de saisie où l'utilisateur pourra entrer les notes d'Évaluation à Moyen Terme (EMD).
    private TextView moyView;
    //Ici, une variable moyView est déclarée pour représenter un élément de texte (TextView) où la moyenne du module en cours sera affichée à l'utilisateur.
    private TextView ceofView;
    //Cette ligne déclare ceofView en tant que TextView utilisé pour afficher le coefficient attribué à un module spécifique
    private TextView creditView;
    //Cette déclaration crée une variable creditView qui sera utilisée pour faire référence à un TextView affichant le nombre de crédits attribués à un module.



    private Button button;
    //cette ligne déclare une variable button représentant un bouton permettant à l'utilisateur de passer d'un module à un autre dans l'application.

    java.text.DecimalFormat df = new java.text.DecimalFormat("0.##"); // prendre 2 chiffre aprés la virgule
    private double tp = 0;
    private double td = 0;
    private double emd = 0;
    private double moy1 = 0;
    private double moy2 = 0;
    private double moy3 = 0;
    private double moy4 = 0;
    private double moy5 = 0;
    private double moy = 0;

    private int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Module 01");
        creditView = findViewById(R.id.credit);
        ceofView = findViewById(R.id.ceof);
        tpView = findViewById(R.id.tpM1);
        tdView = findViewById(R.id.tdM1);
        emdView = findViewById(R.id.emdM1);
        moyView = findViewById(R.id.moyModule);
        button = findViewById(R.id.btnbuttonM1);



        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                switch (i){
                    case 1 :
                    {
                        if(!tpView.getText().toString().isEmpty() && !emdView.getText().toString().isEmpty() &&!tdView.getText().toString().isEmpty() ) {
                            td = Double.parseDouble(tdView.getText().toString());
                            tp = Double.parseDouble(tpView.getText().toString());
                            emd = Double.parseDouble(emdView.getText().toString());
                            moy = (((((td + tp) / 2) * 34) + (emd * 66)) / 100);
                            Log.v("Main 2 Activity", "----> moy1 switch : " + moy1);
                            moy1 = moy;
                            moyView.setText(  String.valueOf(df.format(moy)) );
                            break;
                        }}
                    case 2 :{
                        if(!tpView.getText().toString().isEmpty() && !emdView.getText().toString().isEmpty() &&!tdView.getText().toString().isEmpty() ) {
                            td = Double.parseDouble(tdView.getText().toString());
                            tp = Double.parseDouble(tpView.getText().toString());
                            emd = Double.parseDouble(emdView.getText().toString());
                            moy = (((((td + tp) / 2) * 34) + (emd * 66)) / 100);
                            Log.v("Main 2 Activity", "----> moy2 switch : " + moy2);
                            moy2 = moy;
                            moyView.setText(  String.valueOf(df.format(moy)) );
                            break;}
                    }
                    case 3 :
                    {
                        if( !emdView.getText().toString().isEmpty() &&!tdView.getText().toString().isEmpty() ) {

                            td = Double.parseDouble(tdView.getText().toString());
                            emd = Double.parseDouble(emdView.getText().toString());
                            moy = (((((td)) * 34) + (emd * 66)) / 100);
                            Log.v("Main 2 Activity", "----> moy3 switch : " + moy2);
                            moy3 = moy;
                            moyView.setText(String.valueOf(df.format(moy)));
                            break;
                        }
                    }
                    case 4 : {
                        if (!emdView.getText().toString().isEmpty() && !tpView.getText().toString().isEmpty()) {
                            tp = Double.parseDouble(tpView.getText().toString());
                            emd = Double.parseDouble(emdView.getText().toString());
                            moy = (((((tp)) * 34) + (emd * 66)) / 100);
                            Log.v("Main 2 Activity", "----> moy4 switch : " + moy2);
                            moy4 = moy;
                            moyView.setText(String.valueOf(df.format(moy)));
                            break;
                        }
                    }

                    default : {
                        if (!emdView.getText().toString().isEmpty()) {


                            emd = Double.parseDouble(emdView.getText().toString());
                            moy = emd;
                            Log.v("Main 2 Activity", "----> moy5 switch : " + moy2);
                            moy5 = moy;
                            moyView.setText(String.valueOf(df.format(moy)));
                            break;
                        }
                    }

                }}
        };
        // event listner for dit text
        tdView.addTextChangedListener(textWatcher);
        tpView.addTextChangedListener(textWatcher);
        emdView.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                switch (i){
                    case 2: {reset(); module2(); break;}
                    case 3: {reset(); module3(); break;}
                    case 4: {reset(); module4(); break;}
                    case 5: {reset(); module5(); break;}
                    default: {
                        Intent intent = new Intent(MainActivity.this, ResultatActivity.class);
                        intent.putExtra("Moyenne1", String.valueOf(moy1));
                        intent.putExtra("Moyenne2", String.valueOf(moy2));
                        intent.putExtra("Moyenne3", String.valueOf(moy3));
                        intent.putExtra("Moyenne4", String.valueOf(moy4));
                        intent.putExtra("Moyenne5", String.valueOf(moy5));
                        startActivity(intent);
                    }
                }

            }
        });
    }

    public void reset() {
        tdView.setText("");
        tpView.setText("");
        emdView.setText("");

        tdView.setEnabled(true);
        tpView.setEnabled(true);
        emdView.setEnabled(true);

        tdView.setHint("Note");
        tpView.setHint("Note");
        emdView.setHint("Note");
        tp=0;td=0;emd=0;
        moy=0;

        moyView.setText( "0.0" );
    }

    public void module2(){
        setTitle("Module 2");

        creditView.setText("2");
        ceofView.setText("2");
    }
    public void module3(){
        setTitle("Module 3");

        creditView.setText("3");
        ceofView.setText("3");

        tpView.setHint("");
        tpView.setEnabled(false);
    }
    public void module4(){
        setTitle("Module 4");

        creditView.setText("3");
        ceofView.setText("3");

        tdView.setHint("");
        tdView.setEnabled(false);
    }
    public void module5(){
        setTitle("Module 5");

        tdView.setHint("");
        tdView.setEnabled(false);
        tpView.setHint("");
        tpView.setEnabled(false);

        creditView.setText("2");
        ceofView.setText("1");
    }
}




