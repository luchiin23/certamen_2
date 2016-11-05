package test.luchiin.com.certamen2.Interactors;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import test.luchiin.com.certamen2.HttpServerConnection;
import test.luchiin.com.certamen2.Interfaces.ConsultaInteractor;
import test.luchiin.com.certamen2.R;
import test.luchiin.com.certamen2.SecondActivity;
import test.luchiin.com.certamen2.ThirdActivity;
import test.luchiin.com.certamen2.Views.Consulta;
import android.content.Intent;

/**
 * Created by Luchiin on 04-11-2016.
 */

public class ConsultaInteractorImpl implements ConsultaInteractor {
    private Intent intent;
    @Override
    public void BuscarU(String user) {
            AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
                String resultado;
                @Override
                protected void onPreExecute(){
                }
                @Override
                protected String doInBackground(Void... params) {
                    //String resultado = new HttpServerConnection().connectToServer("api.github.com/users/"+user+"/repos", 15000);
                    String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202", 15000);
                    return resultado;
                }
                @Override
                protected void onPostExecute(String result) {
                    if(result != null) {
                        intent = new Intent(Consulta.this, SecondActivity.class);
                        intent.putExtra("USER",user);
                        intent.putExtra("RESULT",this.resultado);
                    }else{
                        intent = new Intent(Consulta.this,ThirdActivity.class);
                        intent.putExtra("USER",user);
                    }
                    startActivity(intent);
                }
            };
            task.execute();
            break;
    }
}
