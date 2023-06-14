package TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("firstName")//coming from xml class
    @Test(priority = 1)
    public void test(String name){
        System.out.println(name);
    }

    @Parameters({"city","country","zipCode"})//coming from xml class
    @Test(priority = 2)
    public void multipleParameter(String city, String country, String zipCode){
        System.out.println(city);
        System.out.println(country);
        System.out.println(zipCode);
    }

}
