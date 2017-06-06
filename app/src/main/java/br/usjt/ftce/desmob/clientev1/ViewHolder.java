package br.usjt.ftce.desmob.clientev1;

import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by arqdsis on 24/03/2017.
 */
public class ViewHolder {
    private ImageView fotoCliente;
    private TextView nomeCliente, tituloReclamacao, descricaoReclamacao ;

    public ViewHolder(ImageView fotoCliente, TextView nomeCliente, TextView tituloReclamacao, TextView descricaoReclamacao) {
        this.fotoCliente = fotoCliente;
        this.nomeCliente = nomeCliente;
        this.tituloReclamacao = tituloReclamacao;
        this.descricaoReclamacao = descricaoReclamacao;
    }

    public ImageView getFotoCliente() {
        return fotoCliente;
    }

    public void setFotoCliente(ImageView fotoCliente) {
        this.fotoCliente = fotoCliente;
    }

    public TextView getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(TextView nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public TextView getTituloReclamacao() {
        return tituloReclamacao;
    }

    public void setTituloReclamacao(TextView tituloReclamacao) {
        this.tituloReclamacao = tituloReclamacao;
    }

    public TextView getDescricaoReclamacao() {
        return descricaoReclamacao;
    }

    public void setDescricaoReclamacao(TextView descricaoReclamacao) {
        this.descricaoReclamacao = descricaoReclamacao;
    }
}
