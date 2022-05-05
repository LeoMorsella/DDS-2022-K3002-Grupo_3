import UserExceptions.EasyPasswordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

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
        







}
