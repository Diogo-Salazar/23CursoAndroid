package devandroid.salazar.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

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

        Log.i("POO", pessoa1.toString());
        Log.i("POO", pessoa2.toString());

    }
}