package devandroid.salazar.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.salazar.applistacurso.R;
import devandroid.salazar.applistacurso.controller.PessoaController;
import devandroid.salazar.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa1;
    Pessoa pessoa2;
    PessoaController controller;

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa1 = new Pessoa();
        pessoa1.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa1.setSobrenome(preferences.getString("sobreNome", "NA"));
        pessoa1.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        pessoa1.setTelefoneContato(preferences.getString("telefoneContato", "NA"));

        EditText editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        EditText editSobrenome = findViewById(R.id.editSobrenome);
        EditText editTelefoneContato = findViewById(R.id.editTelefoneContato);
        EditText editNomeCurso = findViewById(R.id.editNomeCurso);

        editPrimeiroNome.setText(pessoa1.getPrimeiroNome());
        editSobrenome.setText(pessoa1.getSobrenome());
        editNomeCurso.setText(pessoa1.getCursoDesejado());
        editTelefoneContato.setText(pessoa1.getTelefoneContato());

        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNome.setText("");
                editSobrenome.setText("");
                editNomeCurso.setText("");
                editTelefoneContato.setText("");

                listaVip.clear();
                listaVip.apply();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa1.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa1.setSobrenome(editSobrenome.getText().toString());
                pessoa1.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa1.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo " + pessoa1.toString(), Toast.LENGTH_LONG).show();

                listaVip.putString("primeiroNome", pessoa1.getPrimeiroNome());
                listaVip.putString("sobreNome", pessoa1.getSobrenome());
                listaVip.putString("nomeCurso", pessoa1.getCursoDesejado());
                listaVip.putString("telefoneContato", pessoa1.getTelefoneContato());
                listaVip.apply();


                //controller.salvar(pessoa1);
            }
        });


    }
}