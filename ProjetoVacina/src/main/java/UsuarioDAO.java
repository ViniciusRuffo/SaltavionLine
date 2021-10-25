import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
/**
 * Verifica se usuário inserido se encontra igualmente no banco de dados
 * @param usuario Inserido pelo usuário
 * @return verdadeiro ou falso
 */
    public boolean verificacaologin(Usuario usuario) {
        String sql = "SELECT * from tb_usuario WHERE usuario=? AND senha=?";
        ConnectionFactory factory = new ConnectionFactory();

        try {
            Connection con = factory.obtemConexao();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getSenha());

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {

                //Verificando se o usuário inserido é adm
                //se for adm exibe tela adm
                if (rs.getString("tipoUsuario").equals("1")) {
                    TelaAdm telaadm = new TelaAdm();
                    telaadm.setVisible(true);
                //Se não for adm exibe tela de funcionario
                } else {
                    Telafunci telafunci = new Telafunci();
                    telafunci.setVisible(true);

                }
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    /**
     * Adiciona usuário no banco de dados com o tipouser Informado atráves da opção
     * selecionada no menu da interface gráfica
     * @param usuario Inserido pelo usuário
     * @throws Exception 
     */
    public void usuarioAdd(Usuario usuario) throws Exception{
        String sql = "INSERT INTO tb_usuario (nome, usuario, senha, tipoUsuario) VALUES (?, ?, ?, ?)";
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection con = factory.obtemConexao();
            PreparedStatement ps = con.prepareStatement(sql)) {
        
        
        ps.setString(1,usuario.getNome());
        ps.setString(2, usuario.getUser());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getTipouser());
        ps.execute();
        
        }
    }
    /**
     * Remove usuário do banco de dados cujo o tipoUser é informado atráves da opção
     * selecionada no menu da interface gráfica
     * @param usuario Selecionado pelo usuário
     * @throws Exception 
     */
    public void usuarioRemover(Usuario usuario) throws Exception {
        String sql = "DELETE FROM tb_usuario WHERE codigo=?";
        
        try (Connection con = ConnectionFactory.obtemConexao();
             PreparedStatement ps = con.prepareStatement(sql)){
        
        ps.setInt(1, usuario.getCodigo());
        ps.execute();
                                     
    }
    }
    /**
     * Obtem usuários do banco de dados cujo o tipouser é informado atráves do pârametro
     * @param tipo tipo dos usuários que deseja obter os dados
     * @return Usuarios cujo o Tipouser for igual ao inserido
     * @throws Exception 
     */
    public Usuario[] obtemUsuarios(String tipo) throws Exception{
        String sql = "SELECT * FROM tb_usuario WHERE tipoUsuario = ?";
        try (Connection con = ConnectionFactory.obtemConexao();
                PreparedStatement ps = con.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            int totalDeUsuarios = rs.last() ? rs.getRow() : 0;
            
            Usuario[] usuarios = new Usuario[totalDeUsuarios];
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String usuario = rs.getString("usuario");
                usuarios[contador] = new Usuario(codigo, nome, usuario);
                contador++;
            }
            return usuarios;
        }
    }
}
