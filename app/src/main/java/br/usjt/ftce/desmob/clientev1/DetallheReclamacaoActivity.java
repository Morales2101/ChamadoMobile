package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetallheReclamacaoActivity extends Activity {
    TextView textViewNome, textViewTitulo, textViewDescricao , txtReclamacaoId;
    ImageView imagemCliente;
    ReclamacaoRequester reclamacaoRequester;
    Reclamacao reclamacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detallhe_cliente);

        textViewNome = (TextView) findViewById(R.id.txt_reclamacao_nome);
        textViewTitulo = (TextView) findViewById(R.id.txt_reclamacao_titulo);
        textViewDescricao = (TextView) findViewById(R.id.txt_reclamacao_descricao);
        imagemCliente = (ImageView) findViewById(R.id.cliente_image_view);
        txtReclamacaoId = (TextView) findViewById(R.id.txt_reclamacao_id);

        Intent intent = getIntent();
        reclamacao = (Reclamacao) intent.getSerializableExtra(ListarReclamacaoActivity.RECLAMACAO);

        textViewNome.setText(reclamacao.getNome());
        textViewTitulo.setText(reclamacao.getTitulo());
        textViewDescricao.setText(reclamacao.getDescricao());
        txtReclamacaoId.setText(reclamacao.getId()+"");

        reclamacaoRequester = new ReclamacaoRequester();

        new DownloadImage().execute(MainActivity.SERVIDOR
                + MainActivity.APPSTRING
                + "/img/" + reclamacao.getImagem()+".jpg");

    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                return reclamacaoRequester.getImage(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        public void onPostExecute(Bitmap result) {
            imagemCliente.setImageBitmap(result);
        }
    }
}
