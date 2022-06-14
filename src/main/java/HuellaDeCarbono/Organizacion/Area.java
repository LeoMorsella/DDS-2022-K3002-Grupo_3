package HuellaDeCarbono.Organizacion;

import java.util.ArrayList;

public class Area {
    public String nombre;
    public ArrayList<Miembro> miembro;
    public Organizacion organizacion;

    public Area(String nombre, ArrayList<Miembro> miembros,Organizacion organizacion) {
        this.nombre = nombre;
        this.miembro = miembros;
        this.organizacion = organizacion;
    }
}
