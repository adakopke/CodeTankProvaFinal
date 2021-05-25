package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CadastroUsuarioArray implements CadastroUsuarios {

    private int loginfound = 0;
    private Usuario[] usuarios;
    private int contador;
    private String adminLogin = "adakopke";



    public CadastroUsuarioArray() {
        this.usuarios = new Usuario[2];
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
            this.expandir();
            System.out.println("novo tamanho do array: " + this.usuarios.length);
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
        loginfound = 0;
        for (int i = 0; i < this.contador; i++) {
            if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario)) {
                System.out.println("Seja bem-vindo: " + usuarios[i].getNome());
                loginfound = 1;
            }

        }
        if (loginfound == 0) {
            System.out.println(usuario + " não autorizado");
        }

    }


    public void remover(String usuario) throws CadastroUsuariosException {
        int escolherNovoAdmin = 0;
        validarExclusao(usuario);
        if (usuario.equals(adminLogin)) {
            escolherNovoAdmin = 1;
        }
        for (int i = 0; i < this.contador; i++) {
            if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario) || this.usuarios[i].getLogin().equalsIgnoreCase("null")) {
                if (this.usuarios[i].getLogin().equalsIgnoreCase(usuario)) {
                    this.contador--;
                }

                if (i < (this.contador)) {
                    this.usuarios[i].setLogin(this.usuarios[i + 1].getLogin());
                    this.usuarios[i].setNome(this.usuarios[i + 1].getNome());
                    this.usuarios[i].setSenha(this.usuarios[i + 1].getSenha());
                    this.usuarios[i + 1].setLogin("null");
                    this.usuarios[i + 1].setSenha("null");
                    this.usuarios[i + 1].setNome("null");

                } else {
                    this.usuarios[i].setLogin("null");
                    this.usuarios[i].setSenha("null");
                    this.usuarios[i].setNome("null");

                }
            }
        }
        if (escolherNovoAdmin == 1) {
            validarAdmin();
        }
        //Trecho está aqui apenas para listar o array depois de chamar o método para conferir o resultado.
        for (int i = 0; i < this.contador; i++) {
            System.out.println(this.usuarios[i].getLogin() + " " + this.usuarios[i].getClass());
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

    private void validarAdmin() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escolha um novo administrador para o sistema");
        for (int j = 0; j < this.contador; j++) {
            System.out.println("ID: " + j + " -> " + this.usuarios[j].getLogin());
        }
        System.out.println("Digite o ID do usuário que será o novo admin");
        int id = Integer.parseInt(teclado.nextLine());
        String login = this.usuarios[id].getLogin();
        String senha = this.usuarios[id].getSenha();
        String nome = this.usuarios[id].getNome();
        this.usuarios[id] = new Admin(login, senha, nome);
        System.out.println(this.usuarios[id].getClass() + " " + this.usuarios[id].getLogin());
        adminLogin = this.usuarios[id].getLogin();


    }



public void listarTodos(Usuario usuario){
        if (usuario instanceof Admin) {
            String[] ordenar = new String[this.contador];
            for (int i = 0; i < this.usuarios.length; i++ ) {
                ordenar[i] = "\n" +
                              " Nome: " + this.usuarios[i].getNome() + "\n" +
                             " Login: " + this.usuarios[i].getLogin() + "\n" +
                             " Senha:  " + this.usuarios[i].getSenha() + "\n" +
                             "\n";
            }

            Arrays.sort(ordenar);
            System.out.println(Arrays.toString(ordenar));


        } else {
            System.out.println("Operação não autorizada");
        }


        }


        }


