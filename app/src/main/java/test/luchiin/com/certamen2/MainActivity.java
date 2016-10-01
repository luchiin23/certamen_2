package test.luchiin.com.certamen2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText edtext;
    public Button boton;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtext = (EditText) findViewById(R.id.edittext);
        boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
                    String resultado;
                    @Override
                    protected void onPreExecute(){

                    }

                    @Override
                    protected String doInBackground(Void... params) {

                        //String resultado = new HttpServerConnection().connectToServer("api.github.com/users/"+edtext.getText().toString()+"/repos", 15000);
                        String resultado = new HttpServerConnection().connectToServer("http://www.mocky.io/v2/57eee3822600009324111202", 15000);
                        return resultado;
                    }

                    @Override
                    protected void onPostExecute(String result) {

                        if(result != null) {
                            String user=edtext.getText().toString();
                            intent = new Intent(MainActivity.this, SecondActivity.class);
                            intent.putExtra("USER",user);
                            intent.putExtra("RESULT",this.resultado);
                        }else{
                            String user=edtext.getText().toString();
                            intent = new Intent(MainActivity.this,ThirdActivity.class);
                            intent.putExtra("USER",user);
                            }
                        startActivity(intent);
                    }
                };
                task.execute();





                break;
        }

    }
}
