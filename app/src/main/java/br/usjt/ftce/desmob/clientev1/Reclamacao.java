package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by arqdsis on 03/03/2017.
 */
public class Reclamacao implements Serializable, Comparable<Reclamacao> {
  private int id;
    private String nome;
    private String titulo;
    private String descricao;


    public Reclamacao(Integer id, String nome, String titulo, String descricao) {
       this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

   public void setId(Integer id) {
       this.id = id;
    }


    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }



    public String getDescricao(){
        return descricao;
    }


    public void setDescricao(String descricao){
        this.descricao = descricao;
    }


    public String getImagem() {
        String foto = this.nome.replace('@', '_');
        return foto.replace('.', '_');
    }


    @Override
    public String toString() {
        return "Reclamacao{" +
                ", name='" + nome + '\'' +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
    @Override
    public int compareTo(Reclamacao reclamacao) {
        return this.nome.compareTo(reclamacao.getNome());
    }
}