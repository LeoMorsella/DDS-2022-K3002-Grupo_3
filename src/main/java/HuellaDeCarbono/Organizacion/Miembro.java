package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Seguridad.ValidadorContrasenias;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Miembro {
    public String nombre;
    public String apellido;
    public String tipoDoc;
    public int numDoc;
    public ArrayList<Area> areas;
    public ArrayList<ArrayList<Trayecto>> recorrido;

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