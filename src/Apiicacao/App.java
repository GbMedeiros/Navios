package Apiicacao;

import Classes.Carga;
import Classes.Frete;
import Gerenciadores.GerenciadorTipoCarga;
import Gerenciadores.GerenciadorCarga;
import Gerenciadores.GerenciadorCliente;
import Gerenciadores.GerenciadorNavio;
import Gerenciadores.GerenciadorPorto;

public class App {
    public static void main(String[] args) {

        GerenciadorPorto portos = GerenciadorPorto.getInstance();
        portos.lerArquivo("portos.dat");
        //System.out.println(portos.toString());

        GerenciadorNavio navios = GerenciadorNavio.getInstance();
        navios.lerArquivos("navios.dat");
        //System.out.printf(navios.toString());

        GerenciadorCliente clientes = GerenciadorCliente.getInstance();
        clientes.lerArquivo("clientes.dat");
        //System.out.println(clientes.toString());

        GerenciadorTipoCarga tipoCargas = GerenciadorTipoCarga.getInstance();
        tipoCargas.lerArquivo("tiposCargas.dat");
        //System.out.println(tipoCargas.toString());

        GerenciadorCarga cargas = GerenciadorCarga.getInstance();
        cargas.lerArquivo("cargas.dat");
        cargas.add(new Carga(111, 1, 305, 639, 20, 1500.0, 485));

        Frete frete1 = new Frete(111, "Mare Brilhante", "b");
        Frete frete2 = new Frete(222, "Vento Sereno", "r");
        Frete frete3 = new Frete(333, "Esperança Azul", "r");
        Frete frete4 = new Frete(444, "Rapido Albatroz", "r");
        Frete frete5 = new Frete(555, "Navegante Eterno", "b");

        System.out.println(frete1);
        System.out.println("\n-------------------");
        System.out.println(frete2);
        System.out.println("\n-------------------");
        System.out.println(frete3);
        System.out.println("\n-------------------");
        System.out.println(frete4);
        System.out.println("\n-------------------");
        System.out.println(frete5);

        System.out.println("\n-------------------");
        frete2.entregue();
        frete4.entregue();

        System.out.println("\n\n\n\n    Frete 2 e 4 foram entregues pelos metodo [public final void entregue()]\n\n");
        System.out.println(frete2);
        System.out.println("\n-------------------");
        System.out.println(frete4);
        System.out.println("\n-------------------");


    }
}
