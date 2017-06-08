package br.usjt.ftce.desmob.clientev1;

import java.io.Serializable;

/**
 * Created by arqdsis on 03/03/2017.
 */
public class Usuario implements Serializable, Comparable<Usuario> {
    private int id;
    private String email;
    private String senha;
    private String tipo;

    public Usuario(int id, String email, String senha, String tipo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagem(){
        String foto = this.email.replace('@', '_');
        return foto.replace('.', '_');
    }

    @Override
    public int compareTo(Usuario usuario) {
        return this.email.compareTo(usuario.getEmail());
    }
}
