package HuellaDeCarbono.ManejoAmbiental;

import HuellaDeCarbono.Repositorios.RepositorioOrganizaciones;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class SectorTerritorial {
    private String municipio;
    private String provincia;
    private AgenteSectorial agenteSectorial;

    public SectorTerritorial(AgenteSectorial agenteSectorial) {
        this.agenteSectorial = agenteSectorial;
    }

    private ArrayList<Organizacion> generarOrganizacionesPorCriterio(List<Organizacion> organizacionesTotales, Object criterioUbicacion) {
        ArrayList<Organizacion> organizacionesDelSector = new ArrayList<>();
        for (Organizacion organizacion : organizacionesTotales) {
            if (organizacion.getUbicacion().getMunicipio() == criterioUbicacion)
                organizacionesTotales.add(organizacion);
        }
        return organizacionesDelSector;
    }

    public ArrayList<Organizacion> getOrganizaciones() {
        List<Organizacion> organizaciones = new ArrayList<>();
        List<Organizacion> organizacionesTotales = RepositorioOrganizaciones.getRepositorio().getOrganizaciones();
        if (municipio != null){
            return generarOrganizacionesPorCriterio(organizacionesTotales, municipio);
        }
        else {
            return generarOrganizacionesPorCriterio(organizacionesTotales, provincia);
        }
    }

    public String getProvincia() {
        return provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public AgenteSectorial getAgenteSectorial() {
        return agenteSectorial;
    }

    public void setAgenteSectorial(AgenteSectorial agenteSectorial) {
        this.agenteSectorial = agenteSectorial;
    }

    //TODO metodo Calculo de Huella
    public Double calcularHC() throws Exception {
        Double HCTotal = 0.0;
        for (Organizacion organizacion: this.getOrganizaciones()){
            HCTotal += organizacion.calcularHC();
        }
        return HCTotal;
    }
}
