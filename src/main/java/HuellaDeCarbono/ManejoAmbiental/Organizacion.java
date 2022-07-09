package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Repositorios.RepositorioMiembros;
import HuellaDeCarbono.Repositorios.RepositorioTrayectos;
import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Repositorios.RepositorioUsuarios;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    public void agregarSector(Area area){
        this.areas.add(area);
    }

    public void generarTrayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto nuevoTrayecto = new Trayecto(salida, llegada, medio);
        RepositorioTrayectos.getRepositorio().agregarTrayecto(nuevoTrayecto);
    }

    public List<List<DatoDeActividad>> getMediciones(){
        List<List<DatoDeActividad>> medicionesOrga = new ArrayList<>();
        for (Area area : this.areas){
            for (List<DatoDeActividad> medicion : area.getMediciones()){
                medicionesOrga.add(medicion);
            }
        }
        return medicionesOrga;
    }

    public Double calculoHuella(){
        List<List<DatoDeActividad>> mediciones = this.getMediciones();
        Double HCmediciones = 0.0;
        Double HCmiembros = 0.0;
        Double HC = 0.0;
        ArrayList<Miembro> miembrosOrg = new ArrayList<>();

        for(List<DatoDeActividad> medicion : mediciones){
            HCmediciones = HCmediciones + medicion.calculoHuella();
            //TODO ==> FALTA HACER LA FUNCION PARA LA HC DE DATO DE ACTIVIDAD
        }

        for(Miembro miembro : RepositorioMiembros.getRepositorio().getMiembros()){
            for(Area area : this.areas){
                if(miembro.getAreas().contains(area)){
                    miembrosOrg.add(miembro);
                }
            }
        }

        for(Miembro miembro : miembrosOrg){
            HCmiembros = HCmiembros + miembro.calculoHuella();
            //TODO ==> IDEM
        }

        HC = HCmediciones + HCmiembros;
        return HC;
    }
}
