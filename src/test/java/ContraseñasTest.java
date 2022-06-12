import HuellaDeCarbono.UserExceptions.EasyPasswordException;
import HuellaDeCarbono.Seguridad.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class ContraseñasTest {


    @Test
        void testCrearUsuarioPasswordFacil(){
            Assertions.assertThrows(EasyPasswordException.class,()-> new Usuario("Dio" ,"password"));
        }

        @Test
        public void testCrearUsuarioPasswordSegura() throws NoSuchAlgorithmException {
            Usuario usuario = new Usuario("Yu" ,"Yagni3210+");
            Assertions.assertEquals(usuario.getUsername(),"Yu");
        }

        @Test
        public void testCrearUsuarioPasswordNoCumpleRequisitos(){
            Assertions.assertThrows(EasyPasswordException.class,()-> new Usuario("Joker","asdfr4"));
        }

        @Test
        public  void testTiempoDeEspera() throws InterruptedException {
            Usuario usuario = new Usuario("Yu" ,"Yagni3210+");
            usuario.loginIncorrecto("asdasdsa");
            usuario.loginIncorrecto("asdasdsa");
            usuario.loginIncorrecto("asdasdsa");
            double res = Math.pow(2,usuario.getCantIntentos());
            Assertions.assertEquals(8,res);
        }


}
