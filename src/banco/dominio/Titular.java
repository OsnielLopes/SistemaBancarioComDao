package banco.dominio;

/**
 *
 * @author osniellopesteixeira
 */
public class Titular {
    
    private Long nro_titular;
    private String nome;
    private String rg;
    private String cpf;

    public Titular(Long nro_titular, String nome, String rg, String cpf) {
        this.nro_titular = nro_titular;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Long getNro_titular() {
        return nro_titular;
    }

    public void setNro_titular(Long nro_titular) {
        this.nro_titular = nro_titular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
}
