package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeMethodAfterMethod {
    @BeforeMethod
    public void setup(){
        System.out.println("beforeMethod");
    }
    @Test
    public void test(){
        System.out.println("Test1");
    }
    @Test
    public void test2(){
        System.out.println("Test2");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("afterMethod");
    }
}
