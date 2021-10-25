
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RelatorioDAO {

    public List<Relatorio> gerarRelatorio(Relatorio relatorio) throws Exception {
        String sql = "SELECT * FROM tb_paciente WHERE data_vacina BETWEEN ? AND ?";

        try (Connection con = ConnectionFactory.obtemConexao();
                PreparedStatement ps = con.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY)) {

            Date datasqlinicial = new Date(relatorio.getDataInicial().getTime());
            Date datasqlfinal = new Date(relatorio.getDataFinal().getTime());
            ps.setDate(1, datasqlinicial);
            ps.setDate(2, datasqlfinal);
            ResultSet rs = ps.executeQuery();
            List<Relatorio> rel = new ArrayList<>();
            rs.beforeFirst();
            int contador = 0;
            int mediaUmContador = 0, mediaDoisContador = 0,
                    mediaTresContador = 0, mediaQuatroContador = 0;

            long diffEmMil = Math.abs(relatorio.getDataFinal().getTime() - relatorio.getDataInicial().getTime());
            long diasDiferenca = TimeUnit.DAYS.convert(diffEmMil, TimeUnit.MILLISECONDS);

            while (rs.next()) {
                int idade = rs.getInt("idade");

                if (idade >= 90) {
                    mediaUmContador++;
                    double mediaUm = (double) mediaUmContador / diasDiferenca;
                    relatorio.setMediaUm(mediaUm);

                } else if (idade >= 70 && idade < 90) {

                    mediaDoisContador++;
                    double MediaDois = (double) mediaDoisContador / diasDiferenca;
                    relatorio.setMediaDois(MediaDois);

                } else if (idade >= 50 && idade < 70) {

                    mediaTresContador++;
                    double mediaTres = (double) mediaTresContador / diasDiferenca;
                    relatorio.setMediaTres(mediaTres);

                } else if (idade < 50) {

                    mediaQuatroContador++;
                    double mediaQuatro = (double) mediaQuatroContador / diasDiferenca;
                    relatorio.setMediaQuatro(mediaQuatro);

                }
                contador++;
            }
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\"+"Relatorio.pdf"));
             
            document.open();
            document.add(new Paragraph("Relatório de média de vacinas diárias"
                    + " entre as datas: \n" + relatorio.getDataInicial() + "\nAté a data: \n" + relatorio.getDataFinal()));
            document.add(new Paragraph("Média de vacinas diárias para pacientes com idade"
                    + " maior ou igual a 90 anos: \n" + relatorio.getMediaUm()));
            document.add(new Paragraph("Média de vacinas diárias para pacientes com idade"
                    + " entre 70 e 90 anos: \n" + relatorio.getMediaDois()));
            document.add(new Paragraph("Média de vacinas diárias para pacientes com idade"
                    + " entre 50 e 70 anos: \n" + relatorio.getMediaTres()));
            document.add(new Paragraph("Média de vacinas diárias para pacientes com idade"
                    + " menor que 50 anos: \n" + relatorio.getMediaQuatro()));
            
            document.close();
            
            rel.add(relatorio);
            return rel;
                        
        }
    }
}
