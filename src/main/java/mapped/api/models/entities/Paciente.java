package mapped.api.models.entities;

public class Paciente {
    private int cdPaciente;
    private String nmPaciente;
    private int nrPeso;
    private int nrAltura;
    private String nmGrupoSanguineo;
    private String flSexoBiologico;

    public Paciente() {
    }

    public Paciente(int cdPaciente, String nmPaciente, int nrPeso, int nrAltura, String nmGrupoSanguineo, String flSexoBiologico) {
        this.cdPaciente = cdPaciente;
        this.nmPaciente = nmPaciente;
        this.nrPeso = nrPeso;
        this.nrAltura = nrAltura;
        this.nmGrupoSanguineo = nmGrupoSanguineo;
        this.flSexoBiologico = flSexoBiologico;
    }

    public int getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(int cdPaciente) {
        this.cdPaciente = cdPaciente;
    }

    public String getNmPaciente() {
        return nmPaciente;
    }

    public void setNmPaciente(String nmPaciente) {
        this.nmPaciente = nmPaciente;
    }

    public int getNrPeso() {
        return nrPeso;
    }

    public void setNrPeso(int nrPeso) {
        this.nrPeso = nrPeso;
    }

    public int getNrAltura() {
        return nrAltura;
    }

    public void setNrAltura(int nrAltura) {
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
