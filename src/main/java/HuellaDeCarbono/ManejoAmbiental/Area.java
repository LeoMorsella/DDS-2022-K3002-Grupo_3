package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;

import java.util.ArrayList;
import java.util.List;

public class Area {
    private String nombre;
    private  ArrayList<Miembro> miembros;
    private  Organizacion organizacion;
    private  List<List<DatoDeActividad>> mediciones = null;

    public Area(String nombre, ArrayList<Miembro> miembros,Organizacion organizacion) {
        this.nombre = nombre;
        this.miembros = miembros;
        this.organizacion = organizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Miembro> miembro) {
        this.miembros = miembro;
    }

    public Organizacion getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public List<List<DatoDeActividad>> getMediciones() {
        return mediciones;
    }

    public void cargarMediciones(String DireccionExcel) {
        String filePath = DireccionExcel;
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<DatoDeActividad> nuevasMedicion = cargaMediciones.lecturaArchivo(0);
        mediciones.add(nuevasMedicion);
    }

    public Double calculoHuella() throws Exception {
        Double HC = 0.0;
        for (Miembro miembro : miembros) {
            HC += miembro.calculoHuella();
        }
        for (List<DatoDeActividad> mediciones : mediciones ) {
            for(DatoDeActividad medicion : mediciones) {
                HC += medicion.calculoHuella();
            }
        }
        return HC;
    }
}
