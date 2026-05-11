package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    @Test
    public void dynamicLoadingTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h4[text()='Hello World!']"))
        );
        Assert.assertEquals(text.getText(), "Hello World!");
    }
    @Test
    public void disappearingElementTest() {
        driver.get("https://the-internet.herokuapp.com/disappearing_elements");
        WebElement home =
                driver.findElement(By.xpath("//a[text()='Home']"));
        Assert.assertTrue(home.isDisplayed());
        driver.navigate().refresh();
        WebElement homeAfterRefresh =
                driver.findElement(By.xpath("//a[text()='Home']"));
        Assert.assertTrue(homeAfterRefresh.isDisplayed());
    }
}