package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.Organizacion.Ubicacion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.lang.Exception;

public class APIDistanciaService {

    private String token = "Bearer 5PLixIkvvSuNT23px0g/L6iOS8N2R6gxj1nbTG1DrSo="; // hardcodeado para pruebas

    private int buscarIdLocalidad(Ubicacion ubicacion) {
        int idProvincia = this.buscarId("provincia", 9,ubicacion.getProvincia());
        int idMunicipio = this.buscarId("municipio", idProvincia, ubicacion.getMunicipio());
        int idLocalidad = this.buscarId("localidad", idMunicipio, ubicacion.getLocalidad());
        return idLocalidad;
    }

    private int buscarId(String variable, int id, Ubicacion ubicacion) throws Exception {
        WebClient client = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object auth = new Object();
        
        switch (variable) {
            case "provincia":
                client = WebClient.create("https://ddstpa.com.ar/api/provincias?offset=1&paisId=" + id);
                break;
            case "municipio":
                client = WebClient.create("https://ddstpa.com.ar/api/municipios?offset=2&provinciaId=" + id);
                break;
            case "localidad":
                client = WebClient.create("https://ddstpa.com.ar/api/localidades?offset=1&municipioId=" + id);
                break;
        }
        
        Response response = client
                .header("Content-Type", "application/json")
                .authorization(token)
                .get();

        int status = response.getStatus();
        System.out.println("Status: " + status);
        String responseBody = response.readEntity(String.class);
        if (status == 200) {
            switch (variable) {
                case "provincia":

                    break;
                case "municipio":

                    break;
                case "localidad":

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + variable);
            }

        } else {
            System.out.println("Error response = " + responseBody);
            throw new Exception("Error en la llamada de búsqueda de " + variable);
        }
    }
    public Float medirDistancia(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {

        int idLocalidadOrigen  = this.buscarIdLocalidad(ubicacion1);
        int idLocalidadDestino = this.buscarIdLocalidad(ubicacion1);

        WebClient clientDistancia = WebClient.create("https://ddstpa.com.ar/api/distancia?localidadOrigenId=" + idLocalidadOrigen + "&calleOrigen=" + ubicacion1.getCalle() + "&alturaOrigen=" + ubicacion1.getAltura() + "&localidadDestinoId=" + idLocalidadDestino + "&calledestino=" + ubicacion2.getCalle() + "&alturaDestino=" + ubicacion2.getAltura());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Object auth = new Object();
        Response response = clientDistancia
                .header("Content-Type", "application/json")
                .authorization(token)
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
