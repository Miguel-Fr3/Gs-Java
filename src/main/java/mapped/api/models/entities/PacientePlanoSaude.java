package mapped.api.models.entities;

import java.util.Date;

public class PacientePlanoSaude {
    private int cdPlanoPaciente;
    private int nrCarteira;
    private Date dtInicio;
    private Date dtFim;
    private int cdPaciente;
    private int cdPlanoSaude;

    public PacientePlanoSaude() {
    }

    public PacientePlanoSaude(int cdPlanoPaciente, int nrCarteira, Date dtInicio, Date dtFim, int cdPaciente, int cdPlanoSaude) {
        this.cdPlanoPaciente = cdPlanoPaciente;
        this.nrCarteira = nrCarteira;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.cdPaciente = cdPaciente;
        this.cdPlanoSaude = cdPlanoSaude;
    }

    public int getCdPlanoPaciente() {
        return cdPlanoPaciente;
    }

    public void setCdPlanoPaciente(int cdPlanoPaciente) {
        this.cdPlanoPaciente = cdPlanoPaciente;
    }

    public int getNrCarteira() {
        return nrCarteira;
    }

    public void setNrCarteira(int nrCarteira) {
        this.nrCarteira = nrCarteira;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public int getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(int cdPaciente) {
        this.cdPaciente = cdPaciente;
    }

    public int getCdPlanoSaude() {
        return cdPlanoSaude;
    }

    public void setCdPlanoSaude(int cdPlanoSaude) {
        this.cdPlanoSaude = cdPlanoSaude;
    }
}
