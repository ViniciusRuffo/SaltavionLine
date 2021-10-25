
import java.util.Date;

public class Relatorio {
    private Date dataInicial;
    private Date dataFinal;
    private double mediaUm;
    private double mediaDois;
    private double mediaTres;
    private double mediaQuatro;
    
    public Relatorio(){
    
    }
    
    public Relatorio (double mediaUm, double mediaDois, double mediaTres, double mediaQuatro){
        this.mediaUm = mediaUm;
        this.mediaDois = mediaDois;
        this.mediaTres = mediaTres;
        this.mediaQuatro = mediaQuatro;
    }
    

    public Relatorio (Date dataInicial, Date dataFinal){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public double getMediaUm() {
        return mediaUm;
    }

    public void setMediaUm(double mediaUm) {
        this.mediaUm = mediaUm;
    }

    public double getMediaDois() {
        return mediaDois;
    }

    public void setMediaDois(double mediaDois) {
        this.mediaDois = mediaDois;
    }

    public double getMediaTres() {
        return mediaTres;
    }

    public void setMediaTres(double mediaTres) {
        this.mediaTres = mediaTres;
    }

    public double getMediaQuatro() {
        return mediaQuatro;
    }

    public void setMediaQuatro(double mediaQuatro) {
        this.mediaQuatro = mediaQuatro;
    }
    
}
