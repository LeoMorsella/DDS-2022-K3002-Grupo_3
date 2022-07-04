package HuellaDeCarbono.CargaDeMediciones;

import HuellaDeCarbono.ManejoAmbiental.Medicion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Lectura de archivo Excel usando Api Apache Poi
    public class CargaDeMediciones {

        private FileInputStream file;
        private XSSFWorkbook workbook;
        private XSSFSheet sheet;
        private String xlFilePath;

        public CargaDeMediciones(){
        }

        public CargaDeMediciones useExistingWorkbook(String filePath) {

            try {
                this.xlFilePath = filePath;
                file = new FileInputStream(xlFilePath);
                workbook = new XSSFWorkbook(file);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public List<Medicion> lecturaArchivo(int sheetNumber) {

            DataFormatter formatter = new DataFormatter();
            Sheet sheet1 = workbook.getSheetAt(sheetNumber);

            Pattern pattern;
            Matcher matcher = null;

            String actividad = null;
            String tipoDeConsumo = null;
            String valor = null;
            String periodicidad = null;
            String periodoImputacion = null;
            String unidad = null;

            List<Medicion> listaMediciones = new ArrayList<>();
            Medicion nuevaMedicion;

            final String primerasFilas = "^[A-E]1|^[A-E]2";
            pattern = Pattern.compile(primerasFilas);

            for (Row row : sheet1) {
                for (Cell cell : row) {

                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    String celdaReferencia = cellRef.formatAsString();
                    matcher = pattern.matcher(cellRef.formatAsString());

                    if (!matcher.matches()) {
                        if (celdaReferencia.contains("A")) {
                            actividad = formatter.formatCellValue(cell);
                        }
                        if (celdaReferencia.contains("B")) {
                            tipoDeConsumo = formatter.formatCellValue(cell);
                        }
                        if (celdaReferencia.contains("C")) {
                            valor = formatter.formatCellValue(cell);
                        }
                        if (celdaReferencia.contains("D")) {
                            unidad = formatter.formatCellValue(cell);
                        }
                        if (celdaReferencia.contains("E")) {
                            periodicidad = formatter.formatCellValue(cell);
                        }
                        if (celdaReferencia.contains("F")){
                            periodoImputacion = formatter.formatCellValue(cell);
                        }
                    }
                }
                if (!matcher.matches()) {
                    nuevaMedicion = new Medicion(actividad, unidad, tipoDeConsumo, valor, periodicidad, periodoImputacion);
                    listaMediciones.add(nuevaMedicion);
                }
            }
            return listaMediciones;
        }

    }



