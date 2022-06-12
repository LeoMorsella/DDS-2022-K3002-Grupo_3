package HuellaDeCarbono.MedioDeTransporte;

import HuellaDeCarbono.Organizacion.Ubicacion;

public class Parada {
    String nombre;
    Ubicacion ubicacion;

    public Parada(String nom, Ubicacion ubi){
        this.nombre = nom;
        this.ubicacion = ubi;
    }
}
