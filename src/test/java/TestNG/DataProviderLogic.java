package TestNG;

import org.testng.annotations.Test;

public class DataProviderLogic {
//    @DataProvider(name="couples")
//    public Object[][] getData(){
//        return new Object[][]{
//                {"Ahmet","Leyla","blue"},
//                {"Anna","Ivan","brown"},
//                {"Mavlen","Ayse","blue"},
//                {"Zinah","Ozan","green"},
//                {"Nazul","Nurik","black"}
//        };
//    }
    @Test(dataProvider="couples",dataProviderClass = AllDataPractice.class)
    public void test1(String firstPerson,String secondPerson,String eyeColor){
        System.out.println(firstPerson+ secondPerson+ eyeColor);
    }
//    @Test
//    public void test2(){
//        System.out.println("Anna"+" Ivan");
//    }
//    @Test
//    public void test3(){
//        System.out.println("Mavlen"+ " Ayse");
//    }
//    @Test
//    public void test4(){
//        System.out.println("Zinah"+" Ozan");
//    }
//    @Test
//    public void test5(){
//        System.out.println("Nazgul"+ " Nurik");
//    }
}
