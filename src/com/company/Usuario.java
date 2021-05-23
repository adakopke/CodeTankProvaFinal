package com.company;

public class Usuario {

    private String login;
    private String senha;
    private String nome;
    private TipoUsuarioEnum tipoUsuario;

    public Usuario() {

    }

    public Usuario(String login, String senha, String nome, TipoUsuarioEnum tipoUsuario) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuarioEnum getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }
}
