package Apiicacao;

import Classes.Porto;
import Gerenciadores.GerenciadorNavio;
import Gerenciadores.GerenciadorPorto;

public class App {
    public static void main(String[] args) {

        GerenciadorPorto portos = GerenciadorPorto.getInstance();
        portos.lerArquivo("portos.dat");
        System.out.println(portos.toString());

        GerenciadorNavio navios = GerenciadorNavio.getInstance();




    }
}
