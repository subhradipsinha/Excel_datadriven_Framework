package com.PageObject.CreatCustomer;

import com.PageObject.Hook.ReadExcelHashMap;
import com.demo.TestBase;

public class Login extends TestBase {
    ReadExcelHashMap readExcelHashMap = new ReadExcelHashMap();
    public void Login(){
        try {
            TestBase.initilize();
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void CreateCustomer(){

    }
}
