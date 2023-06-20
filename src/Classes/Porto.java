package Classes;

public class Porto {
    private Integer codigo;
    private String nome;
    private String pais;
    private Integer distancia;

    public Porto() {
    }


    public Porto(int cod, String name, String country) {
        codigo = cod;
        nome = name;
        pais = country;
        distancia = 0;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer c) {
        codigo = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String p) {
        pais = p;
    }

    @Override
    public String toString() {
        return String.format("[%d] %-10s - %-10S", codigo, nome, pais);
    }
}
