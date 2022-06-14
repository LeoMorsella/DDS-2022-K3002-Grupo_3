package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.Organizacion.Ubicacion;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.lang.Exception;

public class APIDistanciaService {

    public Float medirDistancia(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {

        //Implementar los ID
        WebClient clientDistancia = WebClient.create("https://ddstpa.com.ar/api/distancia?localidadOrigenId="+1+"&calleOrigen=" + ubicacion1.getCalle() + "&alturaOrigen=" + ubicacion1.getAltura() + "&localidadDestinoId="+2+"&calledestino=" + ubicacion2.getCalle() + "&alturaDestino=" + ubicacion2.getAltura());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Response response = clientDistancia
                .header("Content-Type", "application/json")
                .get();

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
            Distancia newDistancia = mapper.readValue(responseBody, Distancia.class);
            return newDistancia.getValor();
        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/user");
        }
}

}
