package APITests;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.CalculoDeDistancias.APITokenGenerator;
import HuellaDeCarbono.Organizacion.Ubicacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class APIDistanciaTest {

    @Test
    public void testDistanciaValida() throws Exception {
        Ubicacion ubicacion1Test = new Ubicacion("Buenos Aires", "La Plata", "79", "1233");

        Ubicacion ubicacion2Test = new Ubicacion("Cordoba", "Cordoba Capital", "101", "783");

        APIDistanciaService distanciaService = new APIDistanciaService();
        Assertions.assertDoesNotThrow(() -> distanciaService.medirDistancia(
                ubicacion1Test, ubicacion2Test
        ));
    }

}
