package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.Movilidad.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;

public class Miembro {
    public String nombre;
    public String apellido;
    public String tipoDoc;
    public int numDoc;
    public ArrayList<Area> areas;
    public ArrayList<ArrayList<Trayecto>> recorrido;


    public void registrarseA(Area area) {
        areas.add(area);
    }

}
