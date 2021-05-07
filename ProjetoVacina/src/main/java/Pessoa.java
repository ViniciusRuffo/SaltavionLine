
import java.util.Date;

public class Pessoa {

    private int codigo;
    private String nome;
    private int idade;
    private Boolean areaSaude;
    private Date dataVacina;

    public Pessoa() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean getAreaSaude() {
        return areaSaude;
    }

    public void setAreaSaude(Boolean areaSaude) {
        this.areaSaude = areaSaude;
    }

    public Date getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(Date dataVacina) {
        this.dataVacina = dataVacina;
    }
}
