package Gerenciadores;

import Classes.Carga;
import Classes.Cliente;
import Classes.TipoCarga;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class GerenciadorCarga {

    private TreeMap<Integer, Carga> cargas;
    private static GerenciadorCarga instance;

    private GerenciadorCarga() {
        cargas = new TreeMap<>();
    }

    public static GerenciadorCarga getInstance() {
        if (instance == null) {
            instance = new GerenciadorCarga();
        }
        return instance;
    }

    public Boolean add(Carga carga) {
        if (cargas.containsKey(carga.getCodigo())) {
            System.err.println("Carga: " + carga.toString() + " já cadastrado.");
            return false;
        }
        cargas.put(carga.getCodigo(), carga);
        return true;
    }

    public Carga buscar(int cod) {
        return cargas.get(cod);
    }

    public void lerArquivo(String file) {
        Path path = Paths.get(file);
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;
                while ((line = reader.readLine()) != null) {

                    String dados[] = line.split(",");
                    int codigo = Integer.parseInt(dados[0]);
                    int codcliente = Integer.parseInt(dados[1]);
                    int origem = Integer.parseInt(dados[2]);
                    int destino = Integer.parseInt(dados[3]);
                    int peso = Integer.parseInt(dados[4]);
                    double valorDeclarado = Double.parseDouble(dados[5]);
                    int codigoTipoCarga = Integer.parseInt(dados[6]);
                    add(new Carga(codigo, codcliente, origem, destino, peso, valorDeclarado,  codigoTipoCarga));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n___________ Cargas _____________\n");
        for (Carga c : cargas.values()) {
            s.append(c).append("\n");
        }
        return s.toString();
    }
}
