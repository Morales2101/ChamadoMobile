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
    ArrayList<Usuario> listaus;
    ReclamacaoRequester reclamacaoResquester;
    UsuarioRequester usuarioRequester;
    Intent intent;
    String chave;
    public static final String LISTA = "br.usjt.ftce.desmob.clientev1.lista";

   public static final String CHAVE = "br.usjt.ftce.desmob.clientev1.busca";
    public static final String SERVIDOR = "http://192.168.56.1:8080";
    public static final String APPSTRING = "/ProjetoMobile";
    public static final String RECURSO = "/rest/locais";
    public static final String RECURSOUSUARIO = "/rest/locais/usuario";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textNome = (EditText) findViewById(R.id.email);
    }

    public void buscarCliente(View view) {
        // Intent intent = new Intent(this, ListarClientesActivity.class);

        //String nome = textNome.getText().toString();
        chave = textNome.getText().toString();
        //intent.putExtra(CHAVE, nome);
        reclamacaoResquester = new ReclamacaoRequester();
        usuarioRequester = new UsuarioRequester();
        String alo = SERVIDOR + APPSTRING + RECURSO;
        if (reclamacaoResquester.isConnected(this)) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        lista = reclamacaoResquester.get(SERVIDOR + APPSTRING + RECURSO, chave);
                        listaus = usuarioRequester.get(SERVIDOR + APPSTRING + RECURSOUSUARIO, CHAVE);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                EditText sEmail = (EditText) findViewById(R.id.email);
                                EditText sSenha = (EditText) findViewById(R.id.senha);
                                String tEmail = sEmail.getText().toString();
                                String tSenha = sSenha.getText().toString();

                          //      Log.v("SENHA DIGITADA :", tSenha);
                                // Log.v("SENHA Recebida :", lista.get(3).getEmail());

                                for(int i = 0 ; i < listaus.size(); i++){
                                if (listaus.get(i).getEmail().equals(tEmail) && listaus.get(i).getSenha().equals(tSenha)) {


                                        intent = new Intent(MainActivity.this, ListarReclamacaoActivity.class);
                                        intent.putExtra(LISTA, lista);
                                        startActivity(intent);
                                }


                                }
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
