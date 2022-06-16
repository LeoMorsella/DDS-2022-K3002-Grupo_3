package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.Organizacion.Ubicacion;

public class pruebaAPIDistanciaService {

    public static void main(String[] args) throws Exception {
        APIDistanciaService API = new APIDistanciaService();
        Ubicacion unaUbicacion = new Ubicacion("ARGENTINA","BUENOS AIRES", "SIN INFORMAR","SIN INFORMAR", "maipu", "100");
        Ubicacion otraUbicacion = new Ubicacion("ARGENTINA","BUENOS AIRES", "ADOLFO ALSINA","CARHUE ","O'Higgins", "200");
        Float distancia = API.medirDistancia(unaUbicacion, otraUbicacion);
        System.out.println(distancia);
    }
}
