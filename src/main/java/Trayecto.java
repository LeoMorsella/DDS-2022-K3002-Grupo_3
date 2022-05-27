public class Trayecto {
    Ubicacion puntoPartida;
    Ubicacion puntoLlegada;
    Medio medioTransporte;

    public Trayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        this.puntoPartida = salida;
        this.puntoLlegada = llegada;
        this.medioTransporte = medio;
    }
}
