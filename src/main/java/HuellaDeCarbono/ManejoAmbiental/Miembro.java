package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.Movilidad.Recorrido;
import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Repositorios.RepositorioMiembros;

import java.util.ArrayList;

public class Miembro {
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int numDoc;
    private ArrayList<Area> areas;
    private ArrayList<Recorrido> recorrido;

    private String mail;

    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Recorrido> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(ArrayList<Recorrido> recorrido) {
        this.recorrido = recorrido;
    }

    public Miembro(String nom, String ape, String tipoDocu, int numeroDoc, ArrayList<Area> listaAreas,
                   ArrayList<Recorrido> unRecorrido){
        this.nombre = nom;
        this.apellido = ape;
        this.tipoDoc = tipoDocu;
        this.numDoc = numeroDoc;
        this.areas = listaAreas;
        this.recorrido = unRecorrido;
        RepositorioMiembros.getRepositorio().agregarMiembro(this);
    }

    public void registrarseA(Area area) {
            areas.add(area);
    }

    public Boolean perteneceA(Area area) {return areas.contains(area);}

    public Double calculoHuella(){
        Double HC = 0.0;

        return HC;
    }
}
