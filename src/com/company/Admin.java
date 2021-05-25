package com.company;

public class Admin extends Usuario {

    public Admin (String login, String senha, String nome) {
        super (login, senha, nome);
    }


    public Admin(Usuario usuario) {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "login='" + super.getLogin() + '\'' +
                ", senha='" + super.getSenha() + '\'' +
                ", nome='" + super.getNome() + '\'' +
                '}';
    }

}
