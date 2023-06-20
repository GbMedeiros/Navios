package Classes;

public class TipoCarga {
    private enum Categoria {
        DURAVEL, PERECIVEL;

    }

    private Integer codigo;
    private String descricao;
    private Categoria categoria;
    private String origemSetor;
    private int tempoMaximo = 0;
    private String material;
    private Double ipi;

    //duravel

    public TipoCarga(int num, String desc, String origemS, String materia, double imposto) {
        codigo = num;
        descricao = desc;
        categoria = Categoria.DURAVEL;
        origemSetor = origemS;
        material = materia;
        ipi = imposto;
    }

    //perecivel
    public TipoCarga(int num, String desc, String origem, int tempoM) {
        codigo = num;
        descricao = desc;
        categoria = Categoria.PERECIVEL;
        origemSetor = origem;
        tempoMaximo = tempoM;
    }

    @Override
    public String toString() {
        if (tempoMaximo != 0) {
            return String.format("\n      [%d] %-10s %-10s || Origem: %-10s | Tempo Maximo: %d dias%n", codigo, descricao, categoria, origemSetor, tempoMaximo);
        } else {
            return String.format("\n        [%d] %-15s %-10s || Origem: %-10s | Material: %-10s | IPI: %.2f R$", codigo, descricao, categoria, origemSetor, material, ipi);
        }
    }








    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getOrigemSetor() {
        return origemSetor;
    }

    public void setOrigemSetor(String origemSetor) {
        this.origemSetor = origemSetor;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getIpi() {
        return ipi;
    }

    public void setIpi(Double ipi) {
        this.ipi = ipi;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
