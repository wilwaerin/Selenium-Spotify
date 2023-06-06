package demo.project.driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {

    public static WebDriver webDriver;

    @BeforeAll
    public static void beforeAll(){

        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){

        System.out.println("beforeEach");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://open.spotify.com/");
    }

    @AfterEach
    public void afterEach(){

        System.out.println("afterEach");
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @AfterAll
    public static void afterAll(){

        System.out.println("afterAll");
    }

}
