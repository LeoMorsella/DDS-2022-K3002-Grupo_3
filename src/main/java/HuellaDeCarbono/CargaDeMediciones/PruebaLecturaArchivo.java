package HuellaDeCarbono.CargaDeMediciones;

public class PruebaLecturaArchivo {
    public static void main(String[] args){
        String filePath = "..\\DDS-2022-K3002-Grupo_3\\MedicionesOrganizacion.xlsx";
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        cargaMediciones.lecturaArchivo(0);

    }


}





