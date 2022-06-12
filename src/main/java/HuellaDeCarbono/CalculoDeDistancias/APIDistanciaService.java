package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.Organizacion.Ubicacion;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.lang.Exception;

public class APIDistanciaService {

    public String obtenerToken(String mail) throws Exception{
        WebClient clientUsers = WebClient.create("https://ddstpa.com.ar/api/user");

        AutenticacionRequest autenticacionRequest = new AutenticacionRequest(mail);
        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(autenticacionRequest);
        System.out.println("Autent request = " + requestBody);


        Response response = clientUsers
                .header("Content-Type", "application/json")
                .post(requestBody);

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 201) {
            System.out.println("Autent response = " + responseBody);
            AutenticacionResponse autenticacionResponse = mapper.readValue(responseBody, AutenticacionResponse.class);
            return autenticacionResponse.getToken();
        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada a /api/user");
        }
    }

    public Float medirDistancia(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {

        //Agregar la parte de ID
        WebClient clientDistancia = WebClient.create("https://ddstpa.com.ar/api/distancia?localidadOrigenId=1&calleOrigen=" + ubicacion1.getCalle() + "&alturaOrigen=" + ubicacion1.getAltura() + "&localidadDestinoId=5&calledestino=" + ubicacion2.getCalle() + "&alturaDestino=" + ubicacion2.getAltura());

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
