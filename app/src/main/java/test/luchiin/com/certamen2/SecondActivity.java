package test.luchiin.com.certamen2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.net.URI;
import java.net.URL;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    TextView ress, head;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle ex = intent.getExtras();
        if (ex != null) {
            String usuario = ex.getString("USER");
            String resultado = ex.getString("RESULTADO");

            ress = (TextView) findViewById(R.id.textView4);
            head = (TextView) findViewById(R.id.textView);
            head.setText("Lista de Repositorios del usuario '"+usuario+"'");

            //procesamiento respuesta

            //mostrar por pantalla
            ress.setText(resultado);
        }


    }

    @Override
    public void onClick(View v) {
        //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.github.com/users/"+ex.getString("USER").toString()+"/repos")));
    }
}
