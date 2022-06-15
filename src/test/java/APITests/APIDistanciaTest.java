package APITests;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.CalculoDeDistancias.APITokenGenerator;
import HuellaDeCarbono.Organizacion.Ubicacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class APIDistanciaTest {

    @Test
    public void testDistanciaValida() throws Exception {

        String pais;
        String provincia;
        String municipio; // Municipio
        String localidad;
        String calle;
        String altura;

        Ubicacion ubicacion1Test = new Ubicacion("Argentina", "Buenos Aires",
                "Capital Federal", "Caballito", "192", "1933");

        Ubicacion ubicacion2Test = new Ubicacion("Argentina", "Cordoba",
                "Cordoba Capital", "Nose", "115", "333");

        APIDistanciaService distanciaService = new APIDistanciaService();
        Assertions.assertDoesNotThrow(() -> distanciaService.medirDistancia(
                ubicacion1Test, ubicacion2Test
        ));
    }

}
