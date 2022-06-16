package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.UserExceptions.BadResponseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

public class APITokenGenerator {

    public String obtenerToken(String mail) throws BadResponseException, JsonProcessingException {
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
            throw new BadRequestException("Error en la llamada a /api/user");
        }
    }

}
