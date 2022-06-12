package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.Organizacion.Ubicacion;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.lang.Exception;

public class APIDistanciaService {

    public Integer obtenerDistancia(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {
        WebClient clientDistancia = WebClient.create("https://ddstpa.com.ar/api/distancia?calleOrigen=" + ubicacion1.getCalle() + "&alturaOrigen=" + ubicacion1.getAltura() + "&calledestino=" + ubicacion2.getCalle() + "&alturaDestino=" + ubicacion2.getAltura());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = clientDistancia
                .header("Content-Type", "application/json")
                .get();

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
        //todavia no se que devuelve el json
            Distancia newDistancia = mapper.readValue(responseBody, Distancia.class);
            System.out.println("Nombre: " + newPokemon.getName());
            System.out.println("Imagen: " + "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + newPokemon.getId() + ".png");
            System.out.println("Habilidades: " + newPokemon.getHabilidades());


        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/user");
        }

        return 1;
}

}
