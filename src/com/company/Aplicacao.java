package com.company;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws CadastroUsuariosException {

        //Carga inicial para teste
        CadastroUsuarioArray cadastros = new CadastroUsuarioArray();
        cadastros.adicionar(new Admin("adakopke", "123456", "Anderson Kopke"));
        cadastros.adicionar(new Usuario("pepe","123456", "Penelope Kopke"));
        cadastros.adicionar(new Usuario("chlote","123456", "Charlotte Kopke"));
        cadastros.adicionar(new Usuario("chlote2","123456", "Charlotte Kopke"));


        //Cadastro adicional para disparar expansão do array
        cadastros.adicionar(new Usuario("chlote3","123456", "Charlotte Kopke"));


        //teste busca com sucesso
        // cadastros.buscar("chlote3");

       //teste de busca com falha
       // cadastros.buscar("pow");

        //Teste remover com sucesso
        cadastros.remover("chlote2");

       //Teste remover com erro
        //cadastros.remover("pow");









    }
}
