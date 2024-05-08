package devandroid.lucas.applistavip.view;

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
import devandroid.lucas.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {


    Pessoa pessoa;
    Pessoa outraPessoa;

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

        pessoa = new Pessoa();
        outraPessoa = new Pessoa();

        outraPessoa.setPrimeiroNome("Lukaz");
        outraPessoa.setSobreNome("Braga");
        outraPessoa.setCursoDesejado("Java");
        outraPessoa.setTelefoneContato("999999955");

        editPrimeiroNomeAluno = findViewById(R.id.editPrimeiroNomeAluno);
        edit_SobrenomeAluno = findViewById(R.id.edit_SobrenomeAluno);
        editCursodesejadoAluno = findViewById(R.id.editCursodesejadoAluno);
        editTelefoneDoAluno = findViewById(R.id.editTelefoneDoAluno);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editPrimeiroNomeAluno.setText(pessoa.getPrimeiroNome());
        edit_SobrenomeAluno.setText(pessoa.getSobreNome());
        editCursodesejadoAluno.setText(pessoa.getCursoDesejado());
        editTelefoneDoAluno.setText(pessoa.getTelefoneContato());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPrimeiroNomeAluno.setText("");
                edit_SobrenomeAluno.setText("");
                editCursodesejadoAluno.setText("");
                editTelefoneDoAluno.setText("");
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

            }
        });

        Log.i("POOAndroid", "Objeto pessoa: " + pessoa.toString());
        Log.i("POOAndroid", "Objeto outraPessoa: " + outraPessoa.toString());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}