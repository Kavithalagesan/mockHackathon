package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DropdownTest extends BaseTest  {
    @Test
    public void dropdownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(1);
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text,"Option 1");

    }
    @Test
    public void checkbox1Test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 =
                driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        checkbox1.click();
        Assert.assertFalse(checkbox1.isSelected());
    }
    @Test
    public void checkbox2Test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox2 =
                driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Assert.assertTrue(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertFalse(checkbox2.isSelected());
        checkbox2.click();
        Assert.assertTrue(checkbox2.isSelected());
    }
}
