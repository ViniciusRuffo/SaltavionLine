
import java.util.Date;

public class Paciente {

    private int codigo;
    private String nome;
    private int idade;
    private Boolean areaSaude;
    private String endereco;
    private String numeroEndereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private int prioridade;
    private Date dataVacina;

    public Paciente(String nome, int idade, Boolean areaSaude, String endereco,
            String numeroEndereco, String complemento,String bairro,
            String cidade, String uf, String cep, int prioridade) {
        this.nome = nome;
        this.idade = idade;
        this.areaSaude = areaSaude;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.prioridade = prioridade;
    }

    public Paciente(int codigo, String nome, int idade, String endereco, String uf,
            boolean areaSaude,int prioridade, Date dataVacina) {
        this.codigo = codigo;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.uf = uf;
        this.areaSaude = areaSaude;
        this.prioridade = prioridade;
        this.dataVacina = dataVacina;
    }
    public Paciente(int codigo, Date dataVacina, int prioridade){
        this.codigo = codigo;
        this.dataVacina = dataVacina;
        this.prioridade = prioridade;
    }

    public Paciente() {

    }
    public String getComplemento(){
        return complemento;
    }
    public void setComplemento(String complemento){
        this.complemento = complemento;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getCidade (){
        return cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getUf(){
        return uf;
    }
    public void setUf(String uf){
        this.uf = uf;
    }
    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
