package com.krce;

import com.krce.pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class LoginTest extends BaseTest {
    @DataProvider(name = "loginData")
    public Object[][] loginData() throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader("src/test/resources/login.csv"));
        return reader.readAll().toArray(Object[][]::new);

    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username,String password,String expectedMessage){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.navigateTo();
        String message = loginPage.login(username,password);
        Assert.assertTrue(message.contains(expectedMessage));
    }
}