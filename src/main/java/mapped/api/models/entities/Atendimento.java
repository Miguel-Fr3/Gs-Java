package mapped.api.models.entities;

import java.util.Date;

public class Atendimento {

    private int cdAtendimento;
    private int cdDescricao;
    private int qtDias;
    private String dsHabito;
    private String dsTempoSono;
    private String dsHereditaria;
    private Date dtEnvio;
    private int fgTipo;
    private int cdPaciente;

    public Atendimento() {
    }

    public Atendimento(int cdAtendimento, int cdDescricao, int qtDias, String dsHabito, String dsTempoSono, String dsHereditaria, Date dtEnvio, int fgTipo, int cdPaciente) {
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

    public int getCdAtendimento() {
        return cdAtendimento;
    }

    public void setCdAtendimento(int cdAtendimento) {
        this.cdAtendimento = cdAtendimento;
    }

    public int getCdDescricao() {
        return cdDescricao;
    }

    public void setCdDescricao(int cdDescricao) {
        this.cdDescricao = cdDescricao;
    }

    public int getQtDias() {
        return qtDias;
    }

    public void setQtDias(int qtDias) {
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

    public Date getDtEnvio() {
        return dtEnvio;
    }

    public void setDtEnvio(Date dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    public int getFgTipo() {
        return fgTipo;
    }

    public void setFgTipo(int fgTipo) {
        this.fgTipo = fgTipo;
    }

    public int getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(int cdPaciente) {
        this.cdPaciente = cdPaciente;
    }
}
