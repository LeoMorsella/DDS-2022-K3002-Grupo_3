package HuellaDeCarbono.Organizacion;

public class Ubicacion {
    String provincia;

    String municipio; // Municipio

    String localidad;
    String calle;
    String altura;

    public Ubicacion(String provincia, String municipio, String localidad, String calle, String altura) {
        this.provincia = provincia;
        this.municipio = municipio;
        this.calle = calle;
        this.altura = altura;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }


}
