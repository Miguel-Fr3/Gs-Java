package mapped.api.dtos;

public class LoginRetornoDto {
    private boolean status;

    public LoginRetornoDto(boolean status) {
        this.status = status;
    }

    public LoginRetornoDto() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
