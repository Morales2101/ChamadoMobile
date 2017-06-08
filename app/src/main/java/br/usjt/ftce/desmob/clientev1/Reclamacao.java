package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by arqdsis on 03/03/2017.
 */
public class Reclamacao implements Serializable, Comparable<Reclamacao> {
    private int id;
    private String nome;
    private Boolean aprovado;
    private String dataHora;
    private String titulo;
    private String descricao;
    private String resposta;
    private int idavaliador;
    private int idCidadao;
    private String email;
    private String senha;


    public Reclamacao(int id, String nome, Boolean aprovado, String dataHora, String titulo, String descricao, String resposta, int idavaliador, int idCidadao, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.aprovado = aprovado;
        this.dataHora = dataHora;
        this.titulo = titulo;
        this.descricao = descricao;
        this.resposta = resposta;
        this.idavaliador = idavaliador;
        this.idCidadao = idCidadao;
        this.email = email;
        this.senha = senha;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getIdavaliador() {
        return idavaliador;
    }

    public void setIdavaliador(int idavaliador) {
        this.idavaliador = idavaliador;
    }

    public int getIdCidadao() {
        return idCidadao;
    }

    public void setIdCidadao(int idCidadao) {
        this.idCidadao = idCidadao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImagem(){
        String foto = this.nome.replace('@', '_');
        return foto.replace('.', '_');
    }

    @Override
    public int compareTo(Reclamacao reclamacao) {
        return this.nome.compareTo(reclamacao.getNome());
    }
}
