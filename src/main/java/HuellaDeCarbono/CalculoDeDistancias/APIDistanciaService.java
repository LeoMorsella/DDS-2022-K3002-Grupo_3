package HuellaDeCarbono.CalculoDeDistancias;

import HuellaDeCarbono.ManejoAmbiental.Ubicacion;
import HuellaDeCarbono.UserExceptions.BadResponseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.lang.Exception;
import java.util.Objects;

public class APIDistanciaService {

    private final String token = "Bearer 5PLixIkvvSuNT23px0g/L6iOS8N2R6gxj1nbTG1DrSo="; // hardcodeado para pruebas

    private int buscarIdLocalidad(Ubicacion ubicacion) throws Exception {
        int idPais      = this.buscarId("pais"     , -1, ubicacion);
        int idProvincia = this.buscarId("provincia", idPais     , ubicacion);
        int idMunicipio = this.buscarId("municipio", idProvincia, ubicacion);
        return this.buscarId("localidad", idMunicipio, ubicacion);
    }

    private int buscarId(String variable, int idSuperior, Ubicacion ubicacion) throws Exception {
        int id = -1;
        WebClient client = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        switch (variable) {
            case "pais":
                client = WebClient.create("https://ddstpa.com.ar/api/paises?offset=1");
                break;
            case "provincia":
                client = WebClient.create("https://ddstpa.com.ar/api/provincias?offset=1&paisId=" + idSuperior);
                break;
            case "municipio":
                client = WebClient.create("https://ddstpa.com.ar/api/municipios?offset=1&provinciaId=" + idSuperior);
                break;
            case "localidad":
                client = WebClient.create("https://ddstpa.com.ar/api/localidades?offset=1&municipioId=" + idSuperior);
                break;
        }

        assert client != null;
        Response response = client
                .header("Content-Type", "application/json")
                .authorization(token)
                .get();

        int status = response.getStatus();
        String responseBody = response.readEntity(String.class);

        if (status == 200) {
            switch (variable) {
                case "pais":
                    Pais[] paises = mapper.readValue(responseBody, Pais[].class);
                    for(Pais pais : paises) {
                        if(Objects.equals(pais.getNombre(), ubicacion.getPais())) {
                            id = pais.getId();
                            break;
                        }
                    }
                    break;
                case "provincia":
                    Provincia[] provincias = mapper.readValue(responseBody, Provincia[].class);
                    for(Provincia provincia : provincias) {
                        if(Objects.equals(provincia.getNombre(), ubicacion.getProvincia())) {
                            id = provincia.getId();
                            break;
                        }
                    }
                    break;
                case "municipio":
                    Municipio[] municipios = mapper.readValue(responseBody, Municipio[].class);
                    for(Municipio municipio : municipios) {
                        if(Objects.equals(municipio.getNombre(), ubicacion.getMunicipio())) {
                            id = municipio.getId();
                            break;
                        }
                    }
                    break;
                case "localidad":
                    Localidad[] localidades = mapper.readValue(responseBody, Localidad[].class);
                    for(Localidad localidad : localidades) {
                        if(Objects.equals(localidad.getNombre(), ubicacion.getLocalidad())) {
                            id = localidad.getId();
                            break;
                        }
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + variable);
            }

            if(id == -1) {
                throw new Exception("id no encontrado");
            } else {
                return id;
            }

        } else {
            System.out.println("Error response = " + responseBody);
            throw new BadResponseException("Error en la llamada de búsqueda de " + variable);
        }
    }
    public Float medirDistancia(Ubicacion ubicacion1, Ubicacion ubicacion2) throws Exception {

        int idLocalidadOrigen  = this.buscarIdLocalidad(ubicacion1);
        int idLocalidadDestino = this.buscarIdLocalidad(ubicacion1);


        WebClient clientDistancia = WebClient.create("https://ddstpa.com.ar/api/distancia?localidadOrigenId=" + idLocalidadOrigen + "&calleOrigen=" + ubicacion1.getCalle() + "&alturaOrigen=" + ubicacion1.getAltura() + "&localidadDestinoId=" + idLocalidadDestino + "&calleDestino=" + ubicacion2.getCalle() + "&alturaDestino=" + ubicacion2.getAltura());

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


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
            throw new BadResponseException("Error en la llamada a /api/user");
        }
    }

}
