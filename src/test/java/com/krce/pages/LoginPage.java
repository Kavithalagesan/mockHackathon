package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");
    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void enterSubmit(){
        driver.findElement(loginButton).click();
    }
    public String enterFlash(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage)).getText();
    }
    public LoginPage(WebDriver driver  ,WebDriverWait wait){
        this.driver=driver;
        this.wait=wait;
    }
    public String login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        enterSubmit();
        return enterFlash();
    }

    public void navigateTo(){
        driver.get("https://the-internet.herokuapp.com/login");
    }
}