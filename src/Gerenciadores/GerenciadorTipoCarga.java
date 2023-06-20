package Gerenciadores;

import Classes.TipoCarga;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeMap;

public class GerenciadorTipoCarga {
    private TreeMap<Integer, TipoCarga> tipoCargas;
    private static GerenciadorTipoCarga instance;
    private GerenciadorTipoCarga(){
        tipoCargas = new TreeMap<>();
    }
    public static GerenciadorTipoCarga getInstance() {
        if (instance == null) instance = new GerenciadorTipoCarga();
        return instance;
    }

    public void add(TipoCarga tp) {
        tipoCargas.put(tp.getCodigo(), tp);
    }

    public TipoCarga buscar(int cod){
        return tipoCargas.get(cod);
    }

    public void lerArquivo(String file) {
        Path path = Paths.get(file);
        try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("utf8"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                Integer codigo = Integer.parseInt(dados[0]);
                String descricao = dados[1];
                String origem = dados[2];
                int aux;
                //verificar se é letra ou numero
                if (dados.length == 4){
                    int tempoMaximo = Integer.parseInt(dados[3]);
                    add(new TipoCarga(codigo, descricao, origem, tempoMaximo));
                } else {
                    String material = dados[3];
                    Double ipi = Double.parseDouble(dados[4]);
                    add(new TipoCarga(codigo, descricao, origem, material, ipi));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\n___________ Tipo Carga _____________\n");
        for (TipoCarga tp : tipoCargas.values()) {
            s.append(tp).append("\n");
        }
        return s.toString();
    }
}
