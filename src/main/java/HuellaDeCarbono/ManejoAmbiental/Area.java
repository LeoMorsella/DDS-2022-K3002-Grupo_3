package HuellaDeCarbono.ManejoAmbiental;

import java.util.ArrayList;

public class Area {
    private String nombre;
    private  ArrayList<Miembro> miembro;
    private  Organizacion organizacion;
    private  ArrayList<Medicion> mediciones;

    public Area(String nombre, ArrayList<Miembro> miembros,Organizacion organizacion) {
        this.nombre = nombre;
        this.miembro = miembros;
        this.organizacion = organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Miembro> getMiembro() {
        return miembro;
    }

    public void setMiembro(ArrayList<Miembro> miembro) {
        this.miembro = miembro;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public void setMediciones(ArrayList<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    public void agregarMedicion(Medicion medicion){
        mediciones.add(medicion);
    }
}
