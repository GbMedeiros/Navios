package Classes;

public class Navio {
    private String name;
    private Double velocidade;
    private Double autonimia;
    private Double custoPorMilhaBasico;

    public Navio() {
    }

    public Navio(String nome, Double velo, Double auto, Double custo) {
        name = nome.toLowerCase();
        velocidade = velo;
        autonimia = auto;
        custoPorMilhaBasico = custo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(Double velocidade) {
        this.velocidade = velocidade;
    }

    public Double getAutonimia() {
        return autonimia;
    }

    public void setAutonimia(Double autonimia) {
        this.autonimia = autonimia;
    }

    public Double getCustoPorMilhaBasico() {
        return custoPorMilhaBasico;
    }

    public void setCustoPorMilhaBasico(Double custoPorMilhaBasico) {
        this.custoPorMilhaBasico = custoPorMilhaBasico;
    }

    @Override
    public String toString() {
        return String.format("%s Velocidade     || Max: %f (nós)    || Autonimia %f     || Custo Por Milha: %f", name, velocidade, autonimia, custoPorMilhaBasico);
    }
}
