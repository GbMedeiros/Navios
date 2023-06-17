package Gerenciadores;

import Classes.Porto;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class GerenciadorPorto {
    private Porto porto;
    private TreeMap<Integer, Porto> portos;
    private static GerenciadorPorto instance;

    private GerenciadorPorto() {
        portos = new TreeMap<>();
    }

    public static GerenciadorPorto getInstance() {
        if (instance == null) {
            instance = new GerenciadorPorto();
        }
        return instance;
    }

    public void add(Porto porto) {
        if (portos.containsKey(porto.getCodigo())) {
            System.err.println("Aviso: Já existe um porto com o identificador indicado.");
        }
        portos.put(porto.getCodigo(), porto);
    }

    public Porto buscar(String porto) {
        return portos.get(porto);
    }

    public Boolean lerArquivo(String name) {
        Path file = Paths.get(name);
        try (BufferedReader reader = Files.newBufferedReader(file, Charset.forName("utf8"))) {
            String line = null;
                while ((line = reader.readLine())!= null) {
                    String dados[] = line.split(",");
                    Integer cod = Integer.parseInt(dados[0]);
                    String nome = dados[1];
                    String pais = dados[2];
                    Porto p = new Porto(cod, nome, pais);
                    add(p);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("___________ Portos _____________\n");
        for (Porto p : portos.values()) {
            s.append(p).append("\n");
        }
        return s.toString();
    }
}
