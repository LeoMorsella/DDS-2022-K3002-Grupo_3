package HuellaDeCarbono.Seguridad;

import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Organizacion.Area;
import HuellaDeCarbono.Organizacion.Miembro;
import HuellaDeCarbono.Organizacion.Rol;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Usuario {
    String username;
    String password;
    Rol rol;
    int cantIntentos = 0;
    Miembro miembro;

    public Usuario(String username, String password, Rol unRol){
        this.validarCredencialesUser(username, password);
        this.rol = unRol;
    }

    private void validarCredencialesUser(String user, String psw){
        this.username = user;
        this.password = psw;
        ValidadorContrasenias.getValidadorContrasenias().validarPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getCantIntentos() {
        return cantIntentos;
    }

    public Rol getRol() {
        return rol;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setCantIntentos(int cantIntentos) {
        this.cantIntentos = cantIntentos;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public void validarLogueo(String password) throws InterruptedException {
        if(this.rol == Rol.MIEMBRO) {
            if(this.password != password) {
                cantIntentos += 1;
                TimeUnit.SECONDS.sleep(2 ^ cantIntentos);
            }
        }
    }


}
