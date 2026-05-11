package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    // Upload file and verify filename
    @Test
    public void fileUploadTest() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFile =
                driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\kavitha\\Downloads\\banner.jpeg");

        driver.findElement(By.id("file-submit")).click();

        WebElement uploadedFile =
                driver.findElement(By.id("uploaded-files"));

        Assert.assertEquals(uploadedFile.getText(), "banner.jpeg");
    }
    @Test
    public void unsupportedFileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile =
                driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\kavitha\\Downloads\\kavitha2026. pdf (1).pdf");
        driver.findElement(By.id("file-submit")).click();
        WebElement uploadedFile =
                driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(uploadedFile.getText(), "kavitha2026. pdf (1).pdf" );

    }
    @Test
    public void uploadPageElementsTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("The Internet"));
        WebElement uploadForm =
                driver.findElement(By.id("file-upload"));
        Assert.assertTrue(uploadForm.isDisplayed());
    }
}
