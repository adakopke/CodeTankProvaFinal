package com.company;

public interface CadastroUsuarios {

    void adicionar(Usuario usuario);

    void buscar(String usuario);

    void remover(String usuario) throws CadastroUsuariosException;

    void listarTodos(Usuario usuario);

}