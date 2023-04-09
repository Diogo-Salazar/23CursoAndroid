package devandroid.salazar.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.salazar.applistacurso.model.Pessoa;
import devandroid.salazar.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }


    public void salvar(Pessoa pessoa1) {
        Log.i("MVC Controller", "Salvo: " + pessoa1.toString());

        listaVip.putString("primeiroNome", pessoa1.getPrimeiroNome());
        listaVip.putString("sobreNome", pessoa1.getSobrenome());
        listaVip.putString("nomeCurso", pessoa1.getCursoDesejado());
        listaVip.putString("telefoneContato", pessoa1.getTelefoneContato());
        listaVip.apply();

    }

    public Pessoa buscar(Pessoa pessoa1) {
        pessoa1.setPrimeiroNome(preferences.getString("primeiroNome", "NA"));
        pessoa1.setSobrenome(preferences.getString("sobreNome", "NA"));
        pessoa1.setCursoDesejado(preferences.getString("nomeCurso", "NA"));
        pessoa1.setTelefoneContato(preferences.getString("telefoneContato", "NA"));

        return pessoa1;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();

    }
}
