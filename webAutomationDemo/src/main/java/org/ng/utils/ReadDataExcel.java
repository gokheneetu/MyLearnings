package org.ng.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;

public class ReadDataExcel {
    Logger logger = Logger.getLogger(ReadDataExcel.class.getName());

    public void readApachePOI() {
        try (FileInputStream fis = new FileInputStream(new File("src/main/resources/data.xlsx"))) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> System.out.println(cell.getStringCellValue());
                        case NUMERIC -> System.out.println(cell.getDateCellValue());
                        case BOOLEAN -> cell.getBooleanCellValue();
                        case FORMULA -> cell.getCellFormula();
                        default -> System.out.print(" \t");
                    }
                }
            }
        } catch (Exception e) {
            logger.info(e.getLocalizedMessage());
        }
    }

    public static void main(String[] args) {
        ReadDataExcel readDataExcel = new ReadDataExcel();
        readDataExcel.readApachePOI();
    }
}
