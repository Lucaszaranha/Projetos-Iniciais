package devandroid.lucas.applistavip.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import devandroid.lucas.applistavip.R;
import devandroid.lucas.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    Pessoa  pessoa;
    Pessoa outraPessoa;

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


        int parada;
        parada = 0;


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}