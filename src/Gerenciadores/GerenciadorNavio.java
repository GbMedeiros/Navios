package Gerenciadores;

import Classes.Navio;
import Classes.Porto;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.TreeMap;

public class GerenciadorNavio {
    private TreeMap<String, Navio> navios;
    private static GerenciadorNavio instance;

    private GerenciadorNavio() {
        navios = new TreeMap<>();
    }

    public static GerenciadorNavio getInstance() {
        if (instance == null) {
            instance = new GerenciadorNavio();
        }
        return instance;
    }

    public Boolean add(Navio navio) {
        if (navios.containsKey(navio.getName())) {
            System.err.println("Navio: " + navio.toString() + " já cadastrado.");
            return false;
        }
        navios.put(navio.getName(), navio);
        return true;
    }

    public Navio buscar(String name) {
        return navios.get(name.toLowerCase());
    }

    public void lerArquivos(String file) {
        Path p = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(p, Charset.forName("utf8"))) {

            String line = null;
            while ((line = reader.readLine()) != null) {

                String[] dados = line.split(",");
                String name = dados[0];
                Double velocidade = Double.parseDouble(dados[1]);
                Double autonomia = Double.parseDouble(dados[2]);
                Double custoPorMilhaBasico = Double.parseDouble(dados[3]);
                Navio n = new Navio(name, velocidade, autonomia, custoPorMilhaBasico);
                add(n);
            }
        } catch (Exception e) {
            throw new RuntimeException("* Nao foi possivel ler os navios");
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n___________ Navios _____________\n");
        for (Navio n : navios.values()) {
            s.append(n).append("\n");
        }
        return s.toString();
    }

}
