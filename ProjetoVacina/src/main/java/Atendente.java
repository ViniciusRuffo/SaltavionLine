
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Atendente {
    
    private int codigo;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    private String user;
    private String senha;
    private boolean verificacao = false;
    
    
    public Atendente() {
        
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
    public boolean getVerificacao(){
        return verificacao;
    }
    public void setVerificacao(boolean verificacao){
        this.verificacao = verificacao;
    }
    public void verificarFuncionario() {
        String sql = "SELECT * from tb_funcionarios WHERE usuario=? AND senha=?";
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection con = factory.obtemConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                TelaAdm telaadm = new TelaAdm();
                telaadm.setVisible(true);
                this.verificacao = true;

            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }
}

