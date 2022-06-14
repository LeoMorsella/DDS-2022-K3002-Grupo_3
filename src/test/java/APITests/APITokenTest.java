package APITests;

import HuellaDeCarbono.CalculoDeDistancias.*;

import HuellaDeCarbono.UserExceptions.BadResponseException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

public class APITokenTest {

    @Test
    public void testCrearTokenValido() throws Exception {
        APITokenGenerator tokenGenerator = new APITokenGenerator();
        Assertions.assertDoesNotThrow(() -> tokenGenerator.obtenerToken("EmailPrueba12244@hotmail.com"));
    }
}
