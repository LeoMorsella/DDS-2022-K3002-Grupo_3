package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.CargaDeMediciones.DatoDeMedicion;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Repositorios.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private String razonSocial;
    private TipoOrg tipo;
    private Ubicacion ubicacion;
    private ArrayList<Area> areas;
    private Clasificacion clasificacion;
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

    public Organizacion(String razonSocial, TipoOrg tipo, Ubicacion ubicacion, ArrayList<Area> areas, Clasificacion clasificacion, ArrayList<Miembro> contactosMail, ArrayList<Miembro> contactosWP) {
        this.razonSocial = razonSocial;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.areas = areas;
        this.clasificacion = clasificacion;
        this.contactosMail = contactosMail;
        this.contactosWP = contactosWP;
    }

    public List<Miembro> getMiembros(){
        List<Miembro> miembros = new ArrayList<>();
        for (Area area: areas){
            for (Miembro miembro: area.getMiembros()){
                miembros.add(miembro);
            }
        }
        return miembros;
    }

    public void agregarSector(Area area){
        this.areas.add(area);
    }

    public void generarTrayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto nuevoTrayecto = new Trayecto(salida, llegada, medio);
        RepositorioTrayectos.getRepositorio().agregarTrayecto(nuevoTrayecto);
    }

    public List<List<DatoDeMedicion>> getMediciones(){
        List<List<DatoDeMedicion>> medicionesOrga = new ArrayList<>();
        for (Area area : this.areas){
            for (List<DatoDeMedicion> datoDeMedicion : area.getMediciones()){
                medicionesOrga.add(datoDeMedicion);
            }
        }
        return medicionesOrga;
    }

    public Double calcularHC() throws Exception {
        Double HC = 0.0;

        for( Area area : areas) {
            HC += area.calcularHC();
        }
        return HC   ;
    }

    public Double HCpromedio() throws Exception {
        return this.calcularHC() / this.getMiembros().size();
    }
}
