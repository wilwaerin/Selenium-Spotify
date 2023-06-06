package demo.project.pages;

import demo.project.methods.Methods;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage {

    Logger logger = LogManager.getLogger(HomePage.class);

    Methods methods;

    public HomePage(){

        methods = new Methods();
    }

    public void closeOneTrust(){

        By closeButtonBy = By.cssSelector("#onetrust-close-btn-container > button");
        if (methods.isElementVisible(closeButtonBy,2)){
            assertTrue(methods.isElementClickable(closeButtonBy,30));
            methods.click(closeButtonBy);
        }
    }

    public void homePageControlWithoutLogin(){

        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Ana sayfa\"]/parent::a"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Ara\"]/parent::a"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Kitaplığın\"]/parent::a"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//button[text()=\"Kaydol\"]"),30)
                ,"Kaydol elementi görünür değil");
        assertTrue(methods.isElementVisible(By.cssSelector("button[data-testid=\"login-button\"]"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.cssSelector("button[data-testid=\"create-playlist-button\"]"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Beğenilen Şarkılar\"]/parent::a"),30)
                ," elementi görünür değil");
    }

    public void oturumAcButonunaTikla(){

        By loginButtonBy = By.cssSelector("button[data-testid=\"login-button\"]");
        assertTrue(methods.isElementVisible(loginButtonBy,30)
                ,loginButtonBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(loginButtonBy,30)
                ,loginButtonBy.toString() + " elementi tıklanabilir değil");
        methods.click(loginButtonBy);
    }

    public void homePageControlWithLogin(){

        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Ana sayfa\"]/parent::a"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//span[text()=\"Ara\"]/parent::a"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.xpath("//button[text()=\"Kitaplığın\"]"),30)
                ," elementi görünür değil");
        assertTrue(methods.isElementVisible(By.cssSelector("button[aria-label=\"Çalma listesi veya klasör oluştur\"]"),30)
                ," elementi görünür değil");
    }

    public void usernameControl(String expectedUsername){

        String actualUsername = methods.getAttribute(By.cssSelector("figure[data-testid=\"user-widget-avatar\"]"),"title");
        assertEquals(expectedUsername, actualUsername);
        logger.info(actualUsername);
    }

    public void dilDegistirButonunaTikla(){

        By languageButtonBy = By.cssSelector("button[data-testid=\"language-selection-button\"]");
        assertTrue(methods.isElementVisible(languageButtonBy,30)
                ,languageButtonBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(languageButtonBy,30)
                ,languageButtonBy.toString() + " elementi tıklanabilir değil");
        methods.click(languageButtonBy);
    }

    public void createNewPlayList(){

        By createPlayListButtonBy = By.cssSelector("button[aria-label=\"Çalma listesi veya klasör oluştur\"]");
        assertTrue(methods.isElementVisible(createPlayListButtonBy,30)
                ,createPlayListButtonBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(createPlayListButtonBy,30)
                ,createPlayListButtonBy.toString() + " elementi tıklanabilir değil");
        methods.click(createPlayListButtonBy);

        By createNewPlaylistButtonBy = By.xpath("//span[text()=\"Yeni bir çalma listesi oluştur\"]/parent::button");
        assertTrue(methods.isElementVisible(createNewPlaylistButtonBy,30)
                ,createNewPlaylistButtonBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(createNewPlaylistButtonBy,30)
                ,createNewPlaylistButtonBy.toString() + " elementi tıklanabilir değil");
        methods.click(createNewPlaylistButtonBy);
    }

    public void clickDismissButton(){

        By dismissButton = By.cssSelector("button[data-click-to-action-id=\"Dismiss_action\"]");
        if (methods.isElementVisible(dismissButton,2)){
            methods.click(dismissButton);
        }
    }

    public void clickSearchButton(){

        By searchButtonBy = By.xpath("//span[text()=\"Ara\"]/parent::a");
        assertTrue(methods.isElementVisible(searchButtonBy,30));
        assertTrue(methods.isElementClickable(searchButtonBy,30));
        methods.click(searchButtonBy);
    }

}
