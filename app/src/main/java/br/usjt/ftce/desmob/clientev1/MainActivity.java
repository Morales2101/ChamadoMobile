package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    EditText textNome;
    ArrayList<Reclamacao> lista;
    ReclamacaoRequester reclamacaoResquester;
    Intent intent;
    String chave;
    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";
   public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";
    public static final String SERVIDOR = "http://192.168.56.1:8080";
    public static final String APPSTRING = "/ProjetoMobile";
    public static final String RECURSO = "/rest/locais";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.buscar_clientes);
    }

    public void buscarCliente(View view) {
        // Intent intent = new Intent(this, ListarClientesActivity.class);

        //String nome = textNome.getText().toString();
        chave = textNome.getText().toString();
        //intent.putExtra(CHAVE, nome);
        reclamacaoResquester = new ReclamacaoRequester();
        String alo = SERVIDOR + APPSTRING + RECURSO;
        System.out.println("ALO: " + alo);
        if (reclamacaoResquester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        lista = reclamacaoResquester.get(SERVIDOR + APPSTRING + RECURSO, chave);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                intent = new Intent(MainActivity.this, ListarReclamacaoActivity.class);
                                intent.putExtra(LISTA, lista);
                                startActivity(intent);
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            Toast toast = Toast.makeText(this, "Rede indisponivel", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
