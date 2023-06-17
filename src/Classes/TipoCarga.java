package Classes;

public abstract class TipoCarga {
    private Integer numero;
    private String descricao;

    public TipoCarga() {
    }

    public TipoCarga(int num, String desc) {
        numero = num;
        descricao = desc;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
