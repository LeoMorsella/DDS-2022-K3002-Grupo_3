package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Seguridad.ValidadorContrasenias;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Miembro {
    private String nombre;
    private String apellido;
    private String tipoDoc;
    private int numDoc;
    private ArrayList<Area> areas;
    private ArrayList<ArrayList<Trayecto>> recorrido;

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

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<ArrayList<Trayecto>> getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(ArrayList<ArrayList<Trayecto>> recorrido) {
        this.recorrido = recorrido;
    }

    public Miembro(String nom, String ape, String tipoDocu, int numeroDoc, ArrayList<Area> listaAreas,
                   ArrayList<ArrayList<Trayecto>> unRecorrido){
        this.nombre = nom;
        this.apellido = ape;
        this.tipoDoc = tipoDocu;
        this.numDoc = numeroDoc;
        this.areas = listaAreas;
        this.recorrido = unRecorrido;

    }


    public void registrarseA(Area area) {

            areas.add(area);

    }
}