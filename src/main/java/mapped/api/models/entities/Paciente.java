package mapped.api.models.entities;

public class Paciente {
    private String cdPaciente;
    private String nmPaciente;
    private String nrPeso;
    private String nrAltura;
    private String nmGrupoSanguineo;
    private String flSexoBiologico;

    public Paciente() {
    }

    public Paciente(String cdPaciente, String nmPaciente, String nrPeso, String nrAltura, String nmGrupoSanguineo, String flSexoBiologico) {
        this.cdPaciente = cdPaciente;
        this.nmPaciente = nmPaciente;
        this.nrPeso = nrPeso;
        this.nrAltura = nrAltura;
        this.nmGrupoSanguineo = nmGrupoSanguineo;
        this.flSexoBiologico = flSexoBiologico;
    }

    public String getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(String cdPaciente) {
        this.cdPaciente = cdPaciente;
    }

    public String getNmPaciente() {
        return nmPaciente;
    }

    public void setNmPaciente(String nmPaciente) {
        this.nmPaciente = nmPaciente;
    }

    public String getNrPeso() {
        return nrPeso;
    }

    public void setNrPeso(String nrPeso) {
        this.nrPeso = nrPeso;
    }

    public String getNrAltura() {
        return nrAltura;
    }

    public void setNrAltura(String nrAltura) {
        this.nrAltura = nrAltura;
    }

    public String getNmGrupoSanguineo() {
        return nmGrupoSanguineo;
    }

    public void setNmGrupoSanguineo(String nmGrupoSanguineo) {
        this.nmGrupoSanguineo = nmGrupoSanguineo;
    }

    public String getFlSexoBiologico() {
        return flSexoBiologico;
    }

    public void setFlSexoBiologico(String flSexoBiologico) {
        this.flSexoBiologico = flSexoBiologico;
    }
}
