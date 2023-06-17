package TestNG;

import org.testng.annotations.DataProvider;

public class AllDataPractice {
    @DataProvider(name="couples")
    public Object[][] getData(){
        return new Object[][]{
                {"Ahmet","Leyla","blue"},
                {"Anna","Ivan","brown"},
                {"Mavlen","Ayse","blue"},
                {"Zinah","Ozan","green"},
                {"Nazul","Nurik","black"}
        };
    }
}
