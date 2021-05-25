package com.company;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws CadastroUsuariosException {

        //Carga inicial para teste
        CadastroUsuarioArray cadastros = new CadastroUsuarioArray();
        cadastros.adicionar(new Admin("adakopke", "123456", "Anderson Kopke"));
        cadastros.adicionar(new Usuario("pepe", "123456", "Penelope Kopke"));
        cadastros.adicionar(new Usuario("Zelote2", "123456", "Zelotte Kopke"));
        cadastros.adicionar(new Usuario("chlote", "123456", "Charlotte Kopke"));



        //teste busca com erro
        cadastros.buscar("chlote3");
        System.out.println();

        //teste busca com sucesso
        cadastros.buscar("pepe");
        System.out.println();

        //Teste remover com sucesso
       // cadastros.remover("chlote");
        System.out.println("\n\n\n");

        //Teste remover admin
       // cadastros.remover("adakopke");

        //Teste listar todos

        Usuario[] user = cadastros.getUsuarios();

        cadastros.listarTodos(user[0]);

    }
}
