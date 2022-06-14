package HuellaDeCarbono.Organizacion;

public class Ubicacion {
    String provincia;

    String ciudad;
    String calle;
    String altura;

    public Ubicacion(String provincia, String ciudad, String calle, String altura) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calle = calle;
        this.altura = altura;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
