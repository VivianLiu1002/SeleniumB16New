package com.test.etsy.tests;

import com.test.etsy.pages.EtsyMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EtsyMainTest extends EtsyTestBase{
    @Parameters({"phone","phoneModel","productType","fullSearchName"})
@Test
    public void validateSearchBarFunctionality(String phone, String phoneModel, String productType,String fullSearchName){
    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    etsyMainPage.searchBarFunctionality(phone,phoneModel,productType,fullSearchName);
}
}
