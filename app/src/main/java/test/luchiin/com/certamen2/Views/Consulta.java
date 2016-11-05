package test.luchiin.com.certamen2.Views;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import test.luchiin.com.certamen2.HttpServerConnection;
import test.luchiin.com.certamen2.Interfaces.ConsultaPresenter;
import test.luchiin.com.certamen2.Interfaces.ConsultaView;
import test.luchiin.com.certamen2.Presenters.ConsultaPresenterImpl;
import test.luchiin.com.certamen2.R;
import test.luchiin.com.certamen2.SecondActivity;
import test.luchiin.com.certamen2.ThirdActivity;

public class Consulta extends AppCompatActivity implements ConsultaView {
    public EditText edtext;
    public Button boton;
    private ConsultaPresenter pres;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Consulta);

        edtext = (EditText) findViewById(R.id.edittext);
        boton = (Button) findViewById(R.id.button);
        pres = new ConsultaPresenterImpl(this);
        boton.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void Buscar(View v)
    {
        pres.buscarUser(edtext.getText().toString());
    }



    @Override
    public void nextAct() {

    }
}
