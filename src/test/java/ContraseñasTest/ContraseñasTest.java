package ContraseñasTest;

import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Organizacion.Area;
import HuellaDeCarbono.Organizacion.Miembro;
import HuellaDeCarbono.Organizacion.Rol;
import HuellaDeCarbono.UserExceptions.EasyPasswordException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ContraseñasTest {


        @Test
        public void testCrearMiembroPasswordFacil() {
            ArrayList<Area> areasPrueba = new ArrayList<>();
            ArrayList<ArrayList<Trayecto>> recorrido = new ArrayList<>();
            Assertions.assertThrows(EasyPasswordException.class,()-> new Miembro("Juan","Perez","DNI", Rol.MIEMBRO,123456789,areasPrueba,recorrido,"prueba","password"));
        }

        @Test
        public void testCrearMiembroPasswordSegura() throws NoSuchAlgorithmException {
            ArrayList<Area> areasPrueba = new ArrayList<>();
            ArrayList<ArrayList<Trayecto>> recorrido = new ArrayList<>();
            Miembro miembro = new Miembro("Juan","Perez","DNI", Rol.MIEMBRO,123456789,areasPrueba,recorrido,"prueba","Yagni3210+");
            Assertions.assertEquals(miembro.getUsername(),"prueba");
        }

        @Test
        public void testCrearMiembroPasswordNoCumpleRequisitos() {
            ArrayList<Area> areasPrueba = new ArrayList<>();
            ArrayList<ArrayList<Trayecto>> recorrido = new ArrayList<>();
            Assertions.assertThrows(EasyPasswordException.class,()-> new Miembro ("Juan","Perez","DNI", Rol.MIEMBRO,123456789,areasPrueba,recorrido,"prueba","asdfr4"));
        }

        @Test

        public void testTiempoEsperaLogueo() throws InterruptedException {
            ArrayList<Area> areasPrueba = new ArrayList<>();
            ArrayList<ArrayList<Trayecto>> recorrido = new ArrayList<>();
            Miembro miembro = new Miembro("Juan","Perez","DNI", Rol.MIEMBRO,123456789,areasPrueba,recorrido,"prueba","Yagni3210+");
            miembro.validarLogueo("asasasas");
            miembro.validarLogueo("asasasas");
            miembro.validarLogueo("asasasas");
            double res = Math.pow(2,miembro.getCantIntentos());
            Assertions.assertEquals(8,res);
        }



}
