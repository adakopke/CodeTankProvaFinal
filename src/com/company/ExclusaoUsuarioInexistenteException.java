package com.company;

public class ExclusaoUsuarioInexistenteException extends CadastroUsuariosException {

    public ExclusaoUsuarioInexistenteException() {
        super("Não é possível excluir um usuário inexistente!");
    }

}
