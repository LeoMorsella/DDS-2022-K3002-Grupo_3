package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.Movilidad.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Seguridad.ValidadorContrasenias;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Miembro {
    public String nombre;
    public String apellido;
    public String tipoDoc;
    public Rol rol;
    public int numDoc;
    public ArrayList<Area> areas;
    public ArrayList<ArrayList<Trayecto>> recorrido;
    public String username;
    public String contrasena;
    public int cantidadIntentos;

    public Miembro(String nom, String ape, String tipoDocu, Rol unRol, int numeroDoc, ArrayList<Area> listaAreas,
                   ArrayList<ArrayList<Trayecto>> unRecorrido, String user, String psw){
        this.validarCredencialesUser(user, psw);
        this.nombre = nom;
        this.apellido = ape;
        this.tipoDoc = tipoDocu;
        this.rol = unRol;
        this.numDoc = numeroDoc;
        this.areas = listaAreas;
        this.recorrido = unRecorrido;
        this.cantidadIntentos = 0;
    }

    private void validarCredencialesUser(String user, String psw){
        this.username = user;
        this.contrasena = psw;
        ValidadorContrasenias.getValidadorContrasenias().validarPassword(contrasena);
    }

    public String getUsername() {
        return username;
    }

    public String getContrasena() { return contrasena; }

    public int getCantIntentos(){
        return cantidadIntentos;
    }

    public void validarLogueo(String password) throws InterruptedException {
        if(this.rol == Rol.MIEMBRO) {
            if(this.contrasena != password) {
                cantidadIntentos += 1;
                TimeUnit.SECONDS.sleep(2 ^ cantidadIntentos);
            }
            else{
                //TODO: Mostrar msj de Usuario o Contrasena incorrectos
                this.cantidadIntentos = 0;
            }
        }
        else{
            //TODO: Mostrar msj de tipo de usuario no valido para realizar la accion
        }
    }

    public void registrarseA(Area area) {
        if(this.rol == Rol.MIEMBRO){
            areas.add(area);
        }
    }
}