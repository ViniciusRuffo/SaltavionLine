
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class PacienteDAO {

    /**
     * Adicionar paciente no banco de dados na sua respectiva tabela
     *
     * @param paciente deve conter os dados do paciente
     * @throws Exception
     */
    public void pacienteAdd(Paciente paciente) throws Exception {
        String sql = "INSERT INTO tb_paciente (nome, idade, area_saude, endereco,"
                + " numero, complemento, bairro,cidade, uf, cep, prioridade) VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection con = factory.obtemConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getIdade());
            ps.setBoolean(3, paciente.getAreaSaude());
            ps.setString(4, paciente.getEndereco());
            ps.setString(5, paciente.getNumeroEndereco());
            ps.setString(6, paciente.getComplemento());
            ps.setString(7, paciente.getBairro());
            ps.setString(8, paciente.getCidade());
            ps.setString(9, paciente.getUf());
            ps.setString(10, paciente.getCep());
            ps.setInt(11, paciente.getPrioridade());
            ps.execute();
        }
    }

    /**
     * Obter fila de pacientes
     *
     * @return dados dos pacientes em um ArrayList
     * @throws Exception
     */
    public List<Paciente> obtemFila() throws Exception {
        String sql = "SELECT * FROM tb_paciente ORDER BY prioridade ASC";

        try (Connection con = ConnectionFactory.obtemConexao();
                PreparedStatement ps = con.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {
            ResultSet rs = ps.executeQuery();
            List<Paciente> pacientes = new ArrayList<>();
            rs.beforeFirst();
            int contador = 0;
            while (rs.next()) {

                int codigo = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                String uf = rs.getString("uf");
                boolean areaSaude = rs.getBoolean("area_saude");
                int prioridade = rs.getInt("prioridade");
                Date date = rs.getDate("data_vacina");
                Paciente paciente = new Paciente(codigo, nome, idade, endereco, 
                                        uf,areaSaude, prioridade, date);
                pacientes.add(paciente);
                contador++;
            }
            return pacientes;
        }
    }

    /**
     * Confirmar vacina do paciente, inserindo no banco de dados automáticamente
     * a data atual
     *
     * @param paciente
     * @throws Exception
     */

    public void confirmarVacina(Paciente paciente) throws Exception {
        String sql = "UPDATE tb_paciente SET data_vacina = ?, prioridade = ? WHERE id = ?";

        try (Connection con = ConnectionFactory.obtemConexao();
                PreparedStatement ps = con.prepareStatement(sql)) {
            Date datasql = new Date(paciente.getDataVacina().getTime());
            ps.setDate(1, datasql);
            ps.setInt(2, paciente.getPrioridade());
            ps.setInt(3, paciente.getCodigo());
            ps.executeUpdate();
        }
    }
}
