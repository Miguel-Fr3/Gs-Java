package mapped.api.models.entities;

public class PacientePlanoSaude {
    private String cdPlanoPaciente;
    private String nrCarteira;
    private int dtInicio;
    private int dtFim;
    private String cdPaciente;
    private String cdPlanoSaude;

    public PacientePlanoSaude() {
    }

    public PacientePlanoSaude(String cdPlanoPaciente, String nrCarteira, int dtInicio, int dtFim, String cdPaciente, String cdPlanoSaude) {
        this.cdPlanoPaciente = cdPlanoPaciente;
        this.nrCarteira = nrCarteira;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.cdPaciente = cdPaciente;
        this.cdPlanoSaude = cdPlanoSaude;
    }

    public String getCdPlanoPaciente() {
        return cdPlanoPaciente;
    }

    public void setCdPlanoPaciente(String cdPlanoPaciente) {
        this.cdPlanoPaciente = cdPlanoPaciente;
    }

    public String getNrCarteira() {
        return nrCarteira;
    }

    public void setNrCarteira(String nrCarteira) {
        this.nrCarteira = nrCarteira;
    }

    public int getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(int dtInicio) {
        this.dtInicio = dtInicio;
    }

    public int getDtFim() {
        return dtFim;
    }

    public void setDtFim(int dtFim) {
        this.dtFim = dtFim;
    }

    public String getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(String cdPaciente) {
        this.cdPaciente = cdPaciente;
    }

    public String getCdPlanoSaude() {
        return cdPlanoSaude;
    }

    public void setCdPlanoSaude(String cdPlanoSaude) {
        this.cdPlanoSaude = cdPlanoSaude;
    }
}
