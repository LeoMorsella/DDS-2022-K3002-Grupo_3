import java.util.ArrayList;

public class Miembro {
    public String nombre;
    public String apellido;
    public String tipoDoc;
    public int numDoc;
    public ArrayList<Area> areas;
    public ArrayList<Trayecto> trayectos;


    public  void registrarTrayecto(ArrayList<Trayecto> nuevosTrayectos) {
        for(Trayecto trayecto : nuevosTrayectos) {
            trayectos.add(trayecto);

        }
    }

    public void registrarseA(Area area) {
        areas.add(area);
    }

}
