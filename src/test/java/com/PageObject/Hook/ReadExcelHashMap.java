package com.PageObject.Hook;

import com.demo.ExcelUtility;
import org.testng.annotations.Test;

import java.util.Map;

public class ReadExcelHashMap {
    @Test
    public void test1(){
        try {
            Map<String, String> testData = ExcelUtility.getMapData();
            for (Map.Entry<String,String> map :testData.entrySet()){
                System.out.println(" Key = "+map.getKey()+",Value = "+map.getValue());

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
