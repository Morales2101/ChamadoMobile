package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListarReclamacaoActivity extends Activity {
    ListView listView;
    Reclamacao[] lista;
    public static final String RECLAMACAO = "br.usjt.ftce.desmob.clientev1.nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        listView = (ListView) findViewById(R.id.lista_de_reclamacoes);
        Intent intent = getIntent();
        //String chave = intent.getStringExtra(MainActivity.CHAVE);
        //lista = Data.buscaClientes(chave);
        ArrayList<Reclamacao> reclamacoes = (ArrayList<Reclamacao>) intent.getSerializableExtra(MainActivity.LISTA);
        lista = reclamacoes.toArray(new Reclamacao[0]);
        BaseAdapter adapter = new ReclamacaoAdapter(this, lista);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                Intent intent1 = new Intent(ListarReclamacaoActivity.this, DetallheReclamacaoActivity.class);
                intent1.putExtra(RECLAMACAO, lista[posicao]);
                startActivity(intent1);

            }
        });
    }

}