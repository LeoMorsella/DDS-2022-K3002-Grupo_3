package APIMedicionesTests;

import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;
import org.junit.Test;

import java.util.List;

public class PruebaLecturaArchivo {
    @Test
    public void testCargarDatosALista() throws Exception {
        String filePath = "..\\DDS-2022-K3002-Grupo_3\\MedicionesOrganizacionHC.xlsx";
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<DatoDeActividad> ListaMedicion = cargaMediciones.lecturaArchivo(0);
        System.out.println(ListaMedicion.get(2).getValor());
    }


}





