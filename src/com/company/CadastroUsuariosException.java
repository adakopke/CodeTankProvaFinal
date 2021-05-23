package com.company;

public class CadastroUsuariosException extends Exception {

    private static final String messageDefault = "Ocorreu um fluxo de exceção no CadastroUsuarios.";

    public CadastroUsuariosException(Exception cause) { super(messageDefault, cause);
    }

    public CadastroUsuariosException(String message) {
        super(message);
    }


}
