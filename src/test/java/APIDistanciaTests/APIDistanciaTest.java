package APIDistanciaTests;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.ManejoAmbiental.Ubicacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class APIDistanciaTest {

    @Test
    public void testDistanciaValida() throws Exception {

        Ubicacion ubicacion1Test = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "100");

        Ubicacion ubicacion2Test = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "200");

        APIDistanciaService distanciaService = new APIDistanciaService();
        Assertions.assertDoesNotThrow(() -> distanciaService.medirDistancia(ubicacion1Test, ubicacion2Test));
    }

}
