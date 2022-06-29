package ContraseñasTest;

import HuellaDeCarbono.Seguridad.Rol;
import HuellaDeCarbono.Seguridad.Usuario;
import HuellaDeCarbono.UserExceptions.EasyPasswordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

public class ContraseñasTest {



        @Test
        public void testCrearMiembroPasswordFacil() {

            Assertions.assertThrows(EasyPasswordException.class,()-> new Usuario("prueba","password",Rol.MIEMBRO));
        }

        @Test
        public void testCrearMiembroPasswordSegura() throws NoSuchAlgorithmException {
            Usuario usuarioPrueba = new Usuario("prueba","Yagni3210+",Rol.MIEMBRO);
            Assertions.assertEquals(usuarioPrueba.getUsername(),"prueba");
        }

        @Test
        public void testCrearMiembroPasswordNoCumpleRequisitos() {

            Assertions.assertThrows(EasyPasswordException.class,()-> new Usuario("prueba","asdfr4",Rol.MIEMBRO));
        }

        @Test

        public void testTiempoEsperaLogueo() throws InterruptedException {

            Usuario usuarioPrueba = new Usuario("prueba","Yagni3210+",Rol.MIEMBRO);
            usuarioPrueba.validarLogueo("asasasas");
            usuarioPrueba.validarLogueo("asasasas");
            usuarioPrueba.validarLogueo("asasasas");
            double res = Math.pow(2,usuarioPrueba.getCantIntentos());
            Assertions.assertEquals(8,res);
        }



}
