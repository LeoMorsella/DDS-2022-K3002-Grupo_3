package NotificacionTest;

import HuellaDeCarbono.Notificacion.EnviarMail;
import org.junit.Test;

public class EnvioDeMailTest {

    @Test
    public void testEnvioDeMail() throws Exception {
        String MailDestino = "tphcgrupo3@gmail.com";
        EnviarMail EnviadorDeMail = new EnviarMail();
        EnviadorDeMail.send(MailDestino);
    }

}
