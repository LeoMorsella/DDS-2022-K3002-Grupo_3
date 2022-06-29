package HuellaDeCarbono.ManejoAmbiental;

import java.util.ArrayList;

public class SectorTerritorial {
    private String municipio;
    private String provincia;
    private ArrayList<Organizacion> organizaciones;

    public ArrayList<Organizacion> getOrganizaciones() {
        return organizaciones;
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

    public void setOrganizaciones(ArrayList<Organizacion> organizaciones) {
        this.organizaciones = organizaciones;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    //TODO metodo Calculo de Huella
}
