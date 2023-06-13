package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 1, invocationCount = 10)
    public void test1(){
        System.out.println("I am test1");
    }
    @Test
    public void test2(){
        System.out.println("i am test2");
    }
    @Test
    public void test3(){
        System.out.println("I am test3");
    }
}
