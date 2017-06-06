package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReclamacaoAdapter extends BaseAdapter {

    Reclamacao[] reclamacoes;
    Activity context;

    public ReclamacaoAdapter(Activity context, Reclamacao[] reclamacoes) {
        this.context = context;
        this.reclamacoes = reclamacoes;
    }

    @Override
    public int getCount() {
        return reclamacoes.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < reclamacoes.length) {
            return reclamacoes[i];
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View viewReciclada, ViewGroup viewGroup) {
        View view = viewReciclada;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_cliente, viewGroup, false);

            ImageView fotoCliente = (ImageView) view.findViewById(R.id.foto_cliente);
            TextView nomeReclamacao = (TextView) view.findViewById(R.id.nome_reclamacao);
            TextView tituloReclamacao = (TextView) view.findViewById(R.id.titulo_reclamacao);
            TextView descricaoReclamacao = (TextView) view.findViewById(R.id.descricao_reclamacao);
            //faz cache dos widgets na tagView para usar quando usar quando houver reciclagem
            view.setTag(new ViewHolder(fotoCliente, nomeReclamacao, tituloReclamacao, descricaoReclamacao));
        }
        //usar os widgets cacheados na tag da view reciclado
        ViewHolder holder = (ViewHolder) view.getTag();
        //carrega os novos valores
        Drawable foto = Imagem.getDrawable(context);
        holder.getFotoCliente().setImageDrawable(foto);
        holder.getNomeCliente().setText(reclamacoes[i].getNome());
        holder.getTituloReclamacao().setText(reclamacoes[i].getTitulo());
        holder.getDescricaoReclamacao().setText(reclamacoes[i].getDescricao());
        return view;
    }

}
