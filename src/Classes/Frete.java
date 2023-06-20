package Classes;

import Gerenciadores.GerenciadorCarga;
import Gerenciadores.GerenciadorCliente;
import Gerenciadores.GerenciadorNavio;
import Gerenciadores.GerenciadorPorto;

public class Frete {
    private enum Prioridade {
        Barato, Rapido;
    }

    private Cliente cliente;
    private Carga carga;
    private Navio navio;
    private Porto origem;
    private Porto destino;
    private Prioridade prioridade;
    private Double preco;

    public Frete(int codCarga, String nomeNavio, String pri) {

        carga = GerenciadorCarga.getInstance().buscar(codCarga);
        cliente = carga.getCliente();
        navio = GerenciadorNavio.getInstance().buscar(nomeNavio);
        origem = carga.getOrigem();
        destino = carga.getDestino();
        if (pri.equalsIgnoreCase("r")) prioridade = Prioridade.Rapido;
        else if (pri.equalsIgnoreCase("b")) prioridade = Prioridade.Barato;
        if (navio == null) carga.setSituacao(Carga.Situacao.CANCELADO);
        else carga.setSituacao(Carga.Situacao.LOCADO);

        double custoMilha;
        if (prioridade.equals(Prioridade.Barato)) custoMilha = navio.getCustoPorMilhaBasico();
        else custoMilha = navio.getCustoPorMilhaBasico() * 2;


        Double precoDistancia = Double.parseDouble(String.valueOf(destino.getDistancia() - origem.getDistancia())) * custoMilha;

        Double precoPeso;
        if (carga.getTipoCarga().getIpi() != null) precoPeso = (carga.getPeso() * 1.5) + carga.getTipoCarga().getIpi();
        else precoPeso = carga.getPeso() * 2.0;

        Double custoRegiao;
        if (origem.getPais().equalsIgnoreCase("brasil") && destino.getPais().equalsIgnoreCase("brasil")) {
            custoRegiao = 100000.00;
        } else custoRegiao = 50000.00;

        preco = precoDistancia + precoPeso + custoRegiao;

    }


    public final void entregue() {
        carga.setSituacao(Carga.Situacao.FINALIZADO);
    }

    @Override
    public String toString() {
        return String.format("Cleinte: %-10s%n Carga:%-10s%n Navio: %-10s%n Origem: %-10s%n Destino: %-10s%n Prioridade: %-10s%n ------ PRECO FRETE: %.2f%n -----------Status:%s ", cliente, carga, navio.getName().toUpperCase(), origem, destino, prioridade, preco, carga.getSituacao());
    }

}
