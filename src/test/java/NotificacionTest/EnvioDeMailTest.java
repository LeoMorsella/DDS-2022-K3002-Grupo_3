package NotificacionTest;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.ManejoAmbiental.Medicion;
import HuellaDeCarbono.Notificacion.EnviarMail;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class EnvioDeMailTest {

    @Test
    public void testEnvioDeMail() throws Exception {
        String MailDestino = "tphcgrupo3@gmail.com";
        EnviarMail EnviadorDeMail = new EnviarMail();
        EnviadorDeMail.send(MailDestino);
    }

}
