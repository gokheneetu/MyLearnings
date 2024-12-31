package com.example.selenium4java17;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Specify the path of the Excel file
        String filePath = "path/to/your/excel-file.xlsx";

        // Create a FileInputStream object to read the Excel file
        FileInputStream file = new FileInputStream(new File(filePath));

        // Create a Workbook instance (for .xlsx files use XSSFWorkbook)
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through each row in the sheet
        for (Row row : sheet) {
            // Iterate through each cell in the row
            for (Cell cell : row) {
                // Print the cell value depending on the cell type
                switch (cell.getCellType()) {
                    case STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case BOOLEAN:
                        System.out.print(cell.getBooleanCellValue() + "\t");
                        break;
                    default:
                        System.out.print("Unknown Type" + "\t");
                        break;
                }
            }
            System.out.println(); // New line after each row
        }

        // Close the file input stream
        file.close();
    }
}
