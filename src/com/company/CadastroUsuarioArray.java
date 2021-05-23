package com.company;

import java.util.Scanner;

public class CadastroUsuarioArray implements CadastroUsuarios {
    int loginfound = 0;
    private Usuario[] usuarios;
    private int contador;

    public CadastroUsuarioArray() {
        this.usuarios = new Usuario[4];
        this.contador = 0;

    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


    public void adicionar(Usuario usuario) {
        //System.err.println("Limite de cadastro atingido!");
        if (this.contador == this.usuarios.length) {
            Scanner teclado = new Scanner(System.in);
            System.out.println("Cadastro cheio, deseja expandir (S/N)");
            String resposta = (teclado.nextLine());
            if (resposta.equalsIgnoreCase("S")){
                this.expandir();
            } else {
                System.err.println("Operação abortada");
            }
        }
        if (this.contador < this.usuarios.length) {
            this.usuarios[this.contador] = usuario;
            this.contador++;
        }
    }



    private void expandir() {

        Usuario[] expandir = new Usuario[this.usuarios.length * 2];

        /* Estou deixando a lógica antes da transformação do for, apenas para estudo e consultas futuras
                for (int i = 0; i < this.contador; i++) {
                expandir[i] = this.usuarios[i];
            }

         */

        if (this.contador >= 0) System.arraycopy(this.usuarios, 0, expandir, 0, this.contador);
        this.usuarios = expandir;
    }


    public void buscar(String usuario) {

        if (this.contador == 0) {
            System.out.println("Nenhum registro encontrado");
            return;
        }
        for (int i = 0; i < this.contador; i++) {
            if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario)) {
                System.out.println("Seja bem-vindo: " + usuarios[i].getNome());
                loginfound = 1;
            }

        }
        if (loginfound == 0) {
            System.err.println("Não autorizado");
        }

    }


    public void remover(String usuario) throws CadastroUsuariosException {
        validarExclusao(usuario);
        for (int i = 0; i < this.contador; i++) {
            if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario) || this.usuarios[i].getLogin().equalsIgnoreCase("null")) {
                if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario)) {
                    this.contador--;
                }

                if (i < (this.contador)) {
                    this.usuarios[i].setTipoUsuario(this.usuarios[i + 1].getTipoUsuario());
                    this.usuarios[i].setLogin(this.usuarios[i + 1].getLogin());
                    this.usuarios[i].setNome(this.usuarios[i + 1].getNome());
                    this.usuarios[i].setSenha(this.usuarios[i + 1].getSenha());
                    this.usuarios[i + 1].setTipoUsuario(TipoUsuarioEnum.NULL);
                    this.usuarios[i + 1].setLogin("null");
                    this.usuarios[i + 1].setSenha("null");
                    this.usuarios[i + 1].setNome("null");

                } else {
                    this.usuarios[i].setTipoUsuario(TipoUsuarioEnum.NULL);
                    this.usuarios[i].setLogin("null");
                    this.usuarios[i].setSenha("null");
                    this.usuarios[i].setNome("null");

                }
            }
        }

        //Trecho está aqui apenas para listar o array depois de chamar o método para conferir o resultado.
        for (int i = 0; i < this.contador; i++) {
            System.out.println(usuarios[i]);
        }

    }

    private void validarExclusao(String usuario) throws ExclusaoUsuarioInexistenteException {
        loginfound = 0;
        for (int i = 0; i < this.contador; i++) {
            if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario)) {
                loginfound = 1;
            }
        }

        if (loginfound == 0) {
            throw new ExclusaoUsuarioInexistenteException();
       }
    }


    public void listarTodos(String usuario) {

    }


}


