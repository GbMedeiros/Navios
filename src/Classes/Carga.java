package Classes;

import Gerenciadores.GerenciadorCliente;
import Gerenciadores.GerenciadorPorto;
import Gerenciadores.GerenciadorTipoCarga;


public class Carga {
    public enum Situacao{
        PENDENTE, LOCADO, CANCELADO, FINALIZADO;
    }
    private Cliente cliente;
    private Integer codigo;
    private Integer peso;
    private Double valorDeclarado;
    private Integer tempoMaximo;
    private TipoCarga tipoCarga;
    private Porto origem;
    private Porto destino;
    private Situacao situacao;

    public Carga() {
    }


    //codigo;cliente;origem;destino;peso;valordeclarado;tempomaximo;tipocarga;prioridade;situacao
    public Carga(int cod, String nomeCliente, String ori, String dest, int pes, double valorDe, int codigoTiCa) {
        codigo = cod;
        cliente = GerenciadorCliente.getInstance().buscar(nomeCliente);
        origem = GerenciadorPorto.getInstance().buscar(ori);
        destino = GerenciadorPorto.getInstance().buscar(dest);
        peso = pes;
        valorDeclarado = valorDe;
        tipoCarga = GerenciadorTipoCarga.getInstance().buscar(codigoTiCa);
        if (tipoCarga.getTempoMaximo() != 0) tempoMaximo = tipoCarga.getTempoMaximo() - 5;
        situacao = Situacao.PENDENTE;
    }

    public Carga(int cod, int codCliente, int ori, int dest, int pes, double valorDe, int codigoTiCa) {
        codigo = cod;
        cliente = GerenciadorCliente.getInstance().buscar(codCliente);
        origem = GerenciadorPorto.getInstance().buscar(ori);
        destino = GerenciadorPorto.getInstance().buscar(dest);
        peso = pes;
        valorDeclarado = valorDe;
        tipoCarga = GerenciadorTipoCarga.getInstance().buscar(codigoTiCa);
        if (tipoCarga.getTempoMaximo() != 0) tempoMaximo = tipoCarga.getTempoMaximo() - 5;
        situacao = Situacao.PENDENTE;
    }
    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Porto getOrigem() {
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
        return String.format("[%d] | Peso: %d Kg | Valor Declarado: %.2fR$ | %nTipo de carga: %s | Origem: (%s) -> (%s)", codigo, peso, valorDeclarado, tipoCarga, origem, destino);
    }
}
