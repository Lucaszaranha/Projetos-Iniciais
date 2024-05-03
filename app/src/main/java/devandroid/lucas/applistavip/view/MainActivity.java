package devandroid.lucas.applistavip.view;

import android.os.Bundle;
import android.util.Log;

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

    String dadosPessoa;
    String dadosOutrapessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        outraPessoa = new Pessoa();

        pessoa.setPrimeiroNome("Lucas");

        pessoa.setSobreNome("Aranha");

        pessoa.setCursoDesejado("Programação");

        pessoa.setTelefoneContato("999999999");


        outraPessoa.setPrimeiroNome("Lukaz");

        outraPessoa.setSobreNome("Braga");

        outraPessoa.setCursoDesejado("Java");

        outraPessoa.setTelefoneContato("999999955");


        dadosPessoa = "Primeiro nome: ";

        dadosPessoa += pessoa.getPrimeiroNome();

        dadosPessoa += " Sobrenome: ";

        dadosPessoa += pessoa.getSobreNome();

        dadosPessoa += " Curso desejado: ";

        dadosPessoa += pessoa.getCursoDesejado();

        dadosPessoa += " Telefone de contato: ";

        dadosPessoa += pessoa.getTelefoneContato();

/*

        dadosOutrapessoa = "Primeiro nome: ";

        dadosOutrapessoa += outraPessoa.getPrimeiroNome();

        dadosOutrapessoa += " Sobrenome: ";

        dadosOutrapessoa += outraPessoa.getSobreNome();

        dadosOutrapessoa += " Curso desejado: ";

        dadosOutrapessoa += outraPessoa.getCursoDesejado();

        dadosOutrapessoa += " Telefone de contato: ";

        dadosOutrapessoa += outraPessoa.getTelefoneContato();
*/


        // toString

        Log.i("POOAndroid","Objeto pessoa: "+pessoa.toString());
        Log.i("POOAndroid","Objeto outraPessoa: "+ outraPessoa.toString());


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}