package HuellaDeCarbono.CargaDeMediciones;

import org.apache.poi.ss.usermodel.Row;

public class Medicion {

         private  String actividad;
         private  String tipoDeConsumo;
         private double valor;
        private  String periodicidad;
        private String periodoImputacion;

        public Medicion(String actividad, String tipoDeConsumo, double valor, String periodicidad, String periodoImputacion) {
            this.actividad = actividad;
            this.tipoDeConsumo = tipoDeConsumo;
            this.valor = valor;
            this.periodicidad = periodicidad;
            this.periodoImputacion = periodoImputacion;
        }

    public Medicion() {

    }

    public Medicion(String actividad, String tipoDeConsumo, String periodicidad, String periodoImputacion) {
    }

    public static Medicion fromRow(Row row) {
            String actividad = row.getCell(0).getStringCellValue();
            String tipoDeConsumo = row.getCell(1).getStringCellValue();
            double valor = row.getCell(2).getNumericCellValue();
            String periodicidad = row.getCell(3).getStringCellValue();
            String periodoImputacion = row.getCell(4).getStringCellValue();

            return new Medicion(actividad, tipoDeConsumo, valor, periodicidad, periodoImputacion);
        }


    }


