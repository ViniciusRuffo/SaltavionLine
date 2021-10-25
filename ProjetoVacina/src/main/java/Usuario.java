
public class Usuario {

    private int codigo;
    private String tipouser;
    private String nome;
    private String user;
    private String senha;

    public Usuario() {

    }
    public Usuario(int codigo){
        this.codigo = codigo;
    }
    public Usuario (int codigo, String user, String nome){
        this.codigo = codigo;
        this.user = user;
        this.nome = nome;
    }
    public Usuario(String user, String senha){
        this.user = user;
        this.senha = senha;
    }
    public Usuario(String nome, String user, String tipoUser){
        this.nome = nome;
        this.user = user;
        this.tipouser = tipoUser;
    }
    public Usuario(String nome, String user, String senha, String tipouser){
        this.nome = nome;
        this.user = user;
        this.senha = senha;
        this.tipouser = tipouser;
    }

    public String getTipouser() {
        return tipouser;
    }

    public void setTipouser(String tipouser) {
        this.tipouser = tipouser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public String toString(){
        return this.nome;
    }
}
