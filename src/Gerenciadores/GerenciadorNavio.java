package Gerenciadores;

import Classes.Navio;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class GerenciadorNavio {
    private HashMap<String, Navio> navios;
    private static GerenciadorNavio instance;

    private GerenciadorNavio() {
        navios = new HashMap<>();
    }

    public static GerenciadorNavio getInstance() {
        if (instance == null) {
            instance = new GerenciadorNavio();
        }
        return instance;
    }

    public void add(Navio navio) {
        if (navios.get(navio) != null) {
            System.err.println("Navio: " + navio.toString() + " já cadastrado.");
        } else {
            navios.put(navio.getName(), navio);
        }
    }

    public Navio buscar(String name) {
        return navios.get(name);
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
            throw new RuntimeException(e);
        }
    }

}
