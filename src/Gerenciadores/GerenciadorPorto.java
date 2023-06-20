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
    private Integer distancia = 0;


    private GerenciadorPorto() {
        portos = new TreeMap<>();
    }

    public static GerenciadorPorto getInstance() {
        if (instance == null) {
            instance = new GerenciadorPorto();
        }
        return instance;
    }

    public Boolean add(Porto porto) {
        if (portos.containsKey(porto.getCodigo())) {
            System.err.println("Porto:" + porto.toString() + " já cadastrado.\")");
            return false;
        }
        porto.setDistancia(distancia);
        portos.put(porto.getCodigo(), porto);
        distancia += 100;
        return true;
    }

    public Porto buscar(int porto) {
        return portos.get(porto);
    }

    public Porto buscar(String nomePorto) {
        for (Porto p : portos.values()) {
            if (nomePorto.equals(p.getNome())) return p;
        }
        return null;
    }


    public void lerArquivo(String name) {
        Path file = Paths.get(name);
        try (BufferedReader reader = Files.newBufferedReader(file, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
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
