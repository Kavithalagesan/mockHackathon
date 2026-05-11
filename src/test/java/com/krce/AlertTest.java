package com.krce;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element =
                driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        element.click();
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        WebElement result =
                driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),
                "You successfully clicked an alert");
    }
    @Test
    public void jsConfirmCancelTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element =
                driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        element.click();
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        WebElement result =
                driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),
                "You clicked: Cancel");
    }
    @Test
    public void jsPromptTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element =
                driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        element.click();
        Alert alert =
                wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("key");
        alert.accept();
        WebElement result =
                driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),
                "You entered: key");
    }
    @Test
    public void verifyResultTextChanges() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(
                        By.xpath("//button[text()='Click for JS Alert']"))
                .click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        String firstResult =
                driver.findElement(By.id("result")).getText();
        driver.findElement(
                        By.xpath("//button[text()='Click for JS Confirm']"))
                .click();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();
        String secondResult =
                driver.findElement(By.id("result")).getText();
        Assert.assertNotEquals(firstResult, secondResult);
    }
}