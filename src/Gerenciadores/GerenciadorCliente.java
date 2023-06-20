package Gerenciadores;

import Classes.Cliente;
import Classes.Navio;

import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class GerenciadorCliente {
    private TreeMap<Integer, Cliente> clientes;
    private static GerenciadorCliente instance;

    private GerenciadorCliente() {
        clientes = new TreeMap<>();
    }

    public static GerenciadorCliente getInstance() {
        if (instance == null) {
            instance = new GerenciadorCliente();
        }
        return instance;
    }

    public Boolean add(Cliente cliente) {
        if (clientes.containsKey(cliente.getCodigo())) {
            System.out.printf("\"Cliente " + cliente.toString() + " já cadastrado.");
            return false;
        }
        clientes.put(cliente.getCodigo(), cliente);
        return true;
    }

    public Cliente buscar(int cod) {
        return clientes.get(cod);
    }

    public Cliente buscar(String nome) {
        for (Cliente c : clientes.values()) {
            if (c.getNome().equals(nome.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public void lerArquivo(String file) {
        Path path = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1].toLowerCase();
                String email = dados[2];
                Cliente c = new Cliente(codigo, nome, email);
                add(c);
            }
        } catch (Exception e) {
            throw new RuntimeException("* Nao foi possivel ler os clientes");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n___________ Cliente _____________\n");
        for (Cliente c : clientes.values()) {
            s.append(c).append("\n");
        }
        return s.toString();
    }
}
