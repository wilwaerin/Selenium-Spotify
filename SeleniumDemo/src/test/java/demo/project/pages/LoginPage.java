package demo.project.pages;

import demo.project.methods.Methods;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;

    public LoginPage(){
        methods = new Methods();
    }

    public void loginPageControl(){

       assertTrue(methods.isElementVisible(By.id("login-username"),30));
       assertTrue(methods.isElementVisible(By.id("login-password"),30));
       assertTrue(methods.isElementVisible(By.id("login-button"),30));
    }

    public void validLogin(String username, String password){

        methods.sendKeys(By.id("login-username"),username);
        methods.sendKeys(By.id("login-password"),password);
        assertTrue(methods.isElementClickable(By.id("login-button"),30));
        methods.click(By.id("login-button"));
    }
}
