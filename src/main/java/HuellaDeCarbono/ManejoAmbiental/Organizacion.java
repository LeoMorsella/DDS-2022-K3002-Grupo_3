package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Repositorios.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private TipoOrg tipo;
    private Ubicacion ubicacion;
    private ArrayList<Area> areas;
    private Clasificacion clasificacion;
    private HashMap<Medicion,Miembro> mediciones;
    private ArrayList<Miembro> contactos;
    private SectorTerritorial sectorTerritorial;
    //TODO ver si es conveniente manejarlo como hashmap o listas separadas
    private ArrayList<Medicion> medicions;

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

    public SectorTerritorial getSectorTerritorial() {
        return sectorTerritorial;
    }

    public HashMap<Medicion, Miembro> getMediciones() {
        return mediciones;
    }

    public ArrayList<Miembro> getContactos() {
        return contactos;
    }

    public void setSectorTerritorial(SectorTerritorial sectorTerritorial) {
        this.sectorTerritorial = sectorTerritorial;
    }

    public void setContactos(ArrayList<Miembro> contactos) {
        this.contactos = contactos;
    }

    public void setMediciones(HashMap<Medicion, Miembro> mediciones) {
        this.mediciones = mediciones;
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
        RepositorioTrayectos.getRepositorio().agregarTrayecto(nuevoTrayecto);
    }

    public void cargarMediciones(String DireccionExcel) {
        String filePath = DireccionExcel;
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<Medicion> nuevasMediciones = cargaMediciones.lecturaArchivo(0);
        for (Medicion medicion : nuevasMediciones){
            medicions.add(medicion);
        }
    }
}
