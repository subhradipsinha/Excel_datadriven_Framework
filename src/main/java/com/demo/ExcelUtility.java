package com.demo;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtility {
    public static Map<String,String> getMapData(){
        Map<String,String> testData = new HashMap<String,String>();
        try {
            FileInputStream fileInputStream = new FileInputStream("./Excel/Data.xlsx");
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int lastRowNumber = sheet.getLastRowNum();


            for(int i=0;i<lastRowNumber;i++){
                Row row = sheet.getRow(i);
                Cell keyCell=row.getCell(0);
                String key=keyCell.getStringCellValue().trim();

                Cell valueCell =row.getCell(1);
                String value =valueCell.getStringCellValue().trim();
                testData.put(key,value);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return testData;
    }
}
