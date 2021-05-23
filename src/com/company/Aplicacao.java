package com.company;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws CadastroUsuariosException {

        //Carga inicial para teste
        CadastroUsuarioArray cadastros = new CadastroUsuarioArray();
        cadastros.adicionar(new Usuario("adakopke", "123456", "Anderson Kopke", TipoUsuarioEnum.USER ));
        cadastros.adicionar(new Usuario("pepe","123456", "Penelope Kopke", TipoUsuarioEnum.USER ));
        cadastros.adicionar(new Usuario("chlote","123456", "Charlotte Kopke", TipoUsuarioEnum.ADMIN ));
        cadastros.adicionar(new Usuario("chlote2","123456", "Charlotte Kopke", TipoUsuarioEnum.USER ));


        //Cadastro adicional para disparar expansão do array
        cadastros.adicionar(new Usuario("chlote3","123456", "Charlotte Kopke", TipoUsuarioEnum.USER ));


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
