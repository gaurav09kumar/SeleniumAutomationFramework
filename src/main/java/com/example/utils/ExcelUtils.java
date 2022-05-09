package com.example.utils;

import com.example.constants.FrameWorkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.example.exceptions.FrameworkException;
import com.example.exceptions.InvalidPathForExcelException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = null;

        try (FileInputStream file = new FileInputStream(FrameWorkConstants.getExcelpath())) {

            XSSFWorkbook workBook = new XSSFWorkbook(file);
            XSSFSheet sheet = workBook.getSheet(sheetName);

            Map<String, String> map = null;
            list = new ArrayList<>();
            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= lastrownum; i++) {
                map = new HashMap<String, String>(); //{}
                for (int j = 0; j < lastcolnum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (FileNotFoundException e) {
            throw new InvalidPathForExcelException("Excel File you trying to read is not found");
        } catch (IOException e) {
            throw new FrameworkException("Some IO Exception happened while reading excel file");
        }

        return list;
    }
}
