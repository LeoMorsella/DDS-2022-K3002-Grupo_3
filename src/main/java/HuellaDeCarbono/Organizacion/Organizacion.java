package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.Organizacion.Area;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Movilidad.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;

public class Organizacion {
    public String razonSocial;
    public TipoOrg tipo;
    public Ubicacion ubicacion;
    public ArrayList<Area> areas;
    public String clasificacion;

    public Organizacion(String razon, TipoOrg tipoOrganizacion, Ubicacion ubi, ArrayList<Area> areas, String clasi){
        this.razonSocial = razon;
        this.tipo = tipoOrganizacion;
        this.ubicacion = ubi;
        this.areas = areas;
        this.clasificacion = clasi;
    }

    public void agregarSector(Area area){
        this.areas.add(area);
    }

    public void generarTrayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto nuevoTrayecto = new Trayecto(salida, llegada, medio);
        //TODO: Revisar si los atributos del trayecto se reciben como parametro o los creamos nosotros
        RepositorioTrayectos.getRepositorio().agregarTrayecto(nuevoTrayecto);
    }
}
