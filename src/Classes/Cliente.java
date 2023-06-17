package Classes;

public class Cliente {
    private Integer codigo;
    private String nome;
    private String email;

    public Cliente() {
    }

    public Cliente(int cod, String name, String mail) {
        codigo = cod;
        nome = name;
        email = mail;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(int c) {
        codigo = c;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String n) {
        nome = n;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        email = e;
    }

    @Override
    public String toString(){
        return String.format("[%d] %s | Email: %s", codigo, nome, email);
    }
}
