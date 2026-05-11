package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropdownTest extends BaseTest  {
    @Test
    public void dropdownTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(1);
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text,"Option 1");

    }
}
