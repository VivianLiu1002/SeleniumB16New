package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite//clear the caches --> delete cookies
    //runs before everything
    public void beforeSuite(){
        System.out.println("i am beforeSuite");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("i am beforeClass");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("i am before test annotation");
    }
    @BeforeMethod
    public void beforeMethod(){//set up your automation
        System.out.println("i am before method annotation");
    }
    @Test
    public void test1(){
        System.out.println("i am test1 annotation");
    }
    @Test
    public void test2(){
        System.out.println("i am test2 annotation");
    }
    @AfterMethod
    public void afterMethod(){//tear down driver and screenshot
        System.out.println("i am after method annotation");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("i am afterTest annotation");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("i am afterClass annotation");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("i am after suite");
    }
}
