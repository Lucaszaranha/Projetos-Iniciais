package devandroid.lucas.applistavip.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.lucas.applistavip.R;
import devandroid.lucas.applistavip.controller.PessoaController;
import devandroid.lucas.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listvip";

    Pessoa pessoa;

    PessoaController controller;

    EditText editPrimeiroNomeAluno;
    EditText edit_SobrenomeAluno;
    EditText editCursodesejadoAluno;
    EditText editTelefoneDoAluno;

    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        editPrimeiroNomeAluno = findViewById(R.id.editPrimeiroNomeAluno);
        edit_SobrenomeAluno = findViewById(R.id.edit_SobrenomeAluno);
        editCursodesejadoAluno = findViewById(R.id.editCursodesejadoAluno);
        editTelefoneDoAluno = findViewById(R.id.editTelefoneDoAluno);

        editPrimeiroNomeAluno.setText(pessoa.getPrimeiroNome());
        edit_SobrenomeAluno.setText(pessoa.getSobreNome());
        editCursodesejadoAluno.setText(pessoa.getCursoDesejado());
        editTelefoneDoAluno.setText(pessoa.getTelefoneContato());

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNomeAluno.setText("");
                edit_SobrenomeAluno.setText("");
                editCursodesejadoAluno.setText("");
                editTelefoneDoAluno.setText("");

                listaVip.clear();
                listaVip.apply();


            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setPrimeiroNome(editPrimeiroNomeAluno.getText().toString());
                pessoa.setSobreNome(edit_SobrenomeAluno.getText().toString());
                pessoa.setCursoDesejado(editCursodesejadoAluno.getText().toString());
                pessoa.setTelefoneContato(editTelefoneDoAluno.getText().toString());
                Toast.makeText(MainActivity.this, "Salvo com sucesso" + pessoa.toString(), Toast.LENGTH_LONG).show();


                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobreNome", pessoa.getSobreNome());
                listaVip.putString("cursoDesejado", pessoa.getCursoDesejado());
                listaVip.putString("telefoneContato", pessoa.getTelefoneContato());
                listaVip.apply();

                controller.salvar(pessoa);

            }
        });

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
//