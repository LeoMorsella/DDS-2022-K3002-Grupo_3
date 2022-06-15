package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.Organizacion.Ubicacion;

public class pruebaAPIDistanciaService {

    public static void main(String[] args) throws Exception {
        APIDistanciaService API = new APIDistanciaService();
        Ubicacion unaUbicacion = new Ubicacion("BUENOS AIRES", "GENERAL LAVALLE", "maipu", "100");
        Ubicacion otraUbicacion = new Ubicacion("BUENOS AIRES", "GENERAL PAZ","O'Higgins", "200");
        Float distancia = API.medirDistancia(unaUbicacion, otraUbicacion);
        System.out.println(distancia);
    }
}
