import java.util.concurrent.TimeUnit;

public class Usuario {
    private String username;
    private String password;
    private int cantIntentos;

    public Boolean passwordCoincide(String password){

        return this.password.equals(password);


    }

    public Usuario(String username, String password) {

        this.username = username;
        this.password = password;
        ValidadorContrasenias.getValidadorContrasenias().validarPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {

        return password;

    }

    public void loginIncorrecto(String password) throws InterruptedException {
        if(!passwordCoincide(password)) {
            cantIntentos += 1;
            TimeUnit.MINUTES.sleep(2 ^ cantIntentos);
        }

    }


}
