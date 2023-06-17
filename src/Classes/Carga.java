package Classes;

import Gerenciadores.GerenciadorPorto;

public class Carga {
    private Integer codigo;
    private Integer peso;
    private Double valorDeclarado;
    private Integer tempoMaximo;
    private TipoCarga tipoCarga;
    private Porto origem;
    private Porto destino;

    public Carga() {
    }

    public Carga(int cod, int pes, double valorDe, int tempoMa, TipoCarga tipoCa, String ori, String dest) {
        codigo = cod;
        peso = pes;
        valorDeclarado = valorDe;
        tempoMaximo = tempoMa;
        tipoCarga = tipoCa;
        origem = GerenciadorPorto.getInstance().buscar(ori);
        destino = GerenciadorPorto.getInstance().buscar(dest);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer c) {
        codigo = c;
    }

    public Integer getPeso() {
        return peso;
    }
    public void setPeso(Integer pe) {
        peso = pe;
    }

    public Double getValorDeclarado() {
        return valorDeclarado;
    }
    public void setValorDeclarado(Double v) {
        valorDeclarado = v;
    }
    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }
    public Porto getOrigem(){
        return origem;
    }
    public void setOrigem(String p) {
        //origem = GerenciadorPorto.buscar(p);
    }

    public Porto getDestino() {
        return destino;
    }

    public void setDestino(String d) {
        //origem = GerenciadorPorto.buscar(d);
    }

    @Override
    public String toString() {
        return String.format("[%d] | Peso: %d Kg | Valor Declarado: %fR$ | Tipo de carga: %s | Origem: (%s) -> (%s)", codigo, peso, valorDeclarado, tipoCarga.getDescricao(), origem, destino);
    }
}
