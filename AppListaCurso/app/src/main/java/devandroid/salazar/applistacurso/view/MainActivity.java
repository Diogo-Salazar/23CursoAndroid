package devandroid.salazar.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.salazar.applistacurso.R;
import devandroid.salazar.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa1;
    Pessoa pessoa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa1 = new Pessoa();
        pessoa1.setPrimeiroNome("Diogo");
        pessoa1.setSobrenome("Araujo");
        pessoa1.setCursoDesejado("Android");
        pessoa1.setTelefoneContato("21-22443355");

        pessoa2 = new Pessoa();
        pessoa2.setPrimeiroNome("Alyne");
        pessoa2.setSobrenome("Coelho");
        pessoa2.setCursoDesejado("Cozer");
        pessoa2.setTelefoneContato("24-99896542");

        EditText editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        EditText editSobrenome = findViewById(R.id.editSobrenome);
        EditText editTelefoneContato = findViewById(R.id.editTelefoneContato);
        EditText editNomeCurso = findViewById(R.id.editNomeCurso);

        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNome.setText(pessoa1.getPrimeiroNome());
        editSobrenome.setText(pessoa1.getSobrenome());
        editNomeCurso.setText(pessoa1.getCursoDesejado());
        editTelefoneContato.setText(pessoa1.getTelefoneContato());

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
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa2.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa2.setSobrenome(editSobrenome.getText().toString());
                pessoa2.setCursoDesejado(editNomeCurso.getText().toString());
                pessoa2.setTelefoneContato(editTelefoneContato.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo" + pessoa2.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}