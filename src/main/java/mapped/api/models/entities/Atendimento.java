package mapped.api.models.entities;

public class Atendimento {

    private String cdAtendimento;
    private String cdDescricao;
    private String qtDias;
    private String dsHabito;
    private String dsTempoSono;
    private String dsHereditaria;
    private int dtEnvio;
    private String fgTipo;
    private String cdPaciente;

    public Atendimento() {
    }

    public Atendimento(String cdAtendimento, String cdDescricao, String qtDias, String dsHabito, String dsTempoSono,
                       String dsHereditaria, int dtEnvio, String fgTipo, String cdPaciente) {
        this.cdAtendimento = cdAtendimento;
        this.cdDescricao = cdDescricao;
        this.qtDias = qtDias;
        this.dsHabito = dsHabito;
        this.dsTempoSono = dsTempoSono;
        this.dsHereditaria = dsHereditaria;
        this.dtEnvio = dtEnvio;
        this.fgTipo = fgTipo;
        this.cdPaciente = cdPaciente;
    }

    public String getCdAtendimento() {
        return cdAtendimento;
    }

    public void setCdAtendimento(String cdAtendimento) {
        this.cdAtendimento = cdAtendimento;
    }

    public String getCdDescricao() {
        return cdDescricao;
    }

    public void setCdDescricao(String cdDescricao) {
        this.cdDescricao = cdDescricao;
    }

    public String getQtDias() {
        return qtDias;
    }

    public void setQtDias(String qtDias) {
        this.qtDias = qtDias;
    }

    public String getDsHabito() {
        return dsHabito;
    }

    public void setDsHabito(String dsHabito) {
        this.dsHabito = dsHabito;
    }

    public String getDsTempoSono() {
        return dsTempoSono;
    }

    public void setDsTempoSono(String dsTempoSono) {
        this.dsTempoSono = dsTempoSono;
    }

    public String getDsHereditaria() {
        return dsHereditaria;
    }

    public void setDsHereditaria(String dsHereditaria) {
        this.dsHereditaria = dsHereditaria;
    }

    public int getDtEnvio() {
        return dtEnvio;
    }

    public void setDtEnvio(int dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    public String getFgTipo() {
        return fgTipo;
    }

    public void setFgTipo(String fgTipo) {
        this.fgTipo = fgTipo;
    }

    public String getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(String cdPaciente) {
        this.cdPaciente = cdPaciente;
    }
}
