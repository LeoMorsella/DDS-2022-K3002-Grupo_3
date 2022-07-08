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
    private ArrayList<Medicion> mediciones;
    private ArrayList<Miembro> contactosMail = null;

    private ArrayList<Miembro> contactosWP = null;

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

    public ArrayList<Medicion> getMediciones() {
        return mediciones;
    }

    public ArrayList<Miembro> getContactosMail() {
        return contactosMail;
    }

    public ArrayList<Miembro> getContactosWP() {
        return contactosWP;
    }

    public void setContactosWP(ArrayList<Miembro> contactosWP) {
        this.contactosWP = contactosWP;
    }

    public void setContactosMail(ArrayList<Miembro> contactos) {
        this.contactosMail = contactos;
    }
    public void agregarContactoMail(Miembro Contacto){
        contactosMail.add(Contacto);
    }

    public void agregarContactoWP(Miembro Contacto){
        contactosWP.add(Contacto);
    }

    public void setMediciones(ArrayList<Medicion> mediciones) {
        this.mediciones = mediciones;
    }

    public Organizacion(String razonSocial, TipoOrg tipo, Ubicacion ubicacion, ArrayList<Area> areas, Clasificacion clasificacion) {
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.areas = areas;
        this.clasificacion = clasificacion;
    }

    public void agregarSector(Area area){
        this.areas.add(area);
    }

    public void generarTrayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto nuevoTrayecto = new Trayecto(salida, llegada, medio);
        RepositorioTrayectos.getRepositorio().agregarTrayecto(nuevoTrayecto);
    }


    //Esta mal porque se agregan todas las mediciones a un mismo miembro
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
