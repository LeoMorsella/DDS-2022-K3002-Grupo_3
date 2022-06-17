package HuellaDeCarbono.Organizacion;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Repositorios.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    public String razonSocial;
    public TipoOrg tipo;
    public Ubicacion ubicacion;
    public ArrayList<Area> areas;
    public Clasificacion clasificacion;

    private List<Medicion> mediciones;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoOrg getTipo() {
        return tipo;
    }

    public void setTipo(TipoOrg tipo) {
        this.tipo = tipo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public Clasificacion getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Organizacion(String razon, TipoOrg tipoOrganizacion, Ubicacion ubi, ArrayList<Area> areas, Clasificacion clasi){
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

    public void cargarMediciones(String DireccionExcel) {
        String filePath = DireccionExcel;
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<Medicion> nuevasMediciones = cargaMediciones.lecturaArchivo(0);
        for (Medicion medicion : nuevasMediciones){
            mediciones.add(medicion);
        }
    }
}
