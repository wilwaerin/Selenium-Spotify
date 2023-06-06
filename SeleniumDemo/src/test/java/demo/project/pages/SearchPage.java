package demo.project.pages;

import demo.project.methods.Methods;
import demo.project.methods.MethodsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class SearchPage {

    Logger logger = LogManager.getLogger(SearchPage.class);

    Methods methods;
    MethodsUtil methodsUtil;

    public SearchPage(){

        methods = new Methods();
        methodsUtil = new MethodsUtil();
    }

    public void search(String text){

        By searchBy = By.cssSelector("input[data-testid='search-input']");
        assertTrue(methods.isElementVisible(searchBy,30));
        methods.sendKeys(searchBy, text);
    }

    public void clickTrackMoreButton(){

        By trackBy = By.cssSelector("div[data-testid=\"grid-search-results\"] section[data-testid=\"search-tracks-result\"] div[role=\"row\"]:nth-child(1) div[data-testid=\"tracklist-row\"]");
        assertTrue(methods.isElementVisible(trackBy,30));
        methodsUtil.waitByMilliSeconds(500);
        methods.hoverElement(methods.findElement(trackBy));
        By moreButtonBy = By.cssSelector("div[data-testid=\"grid-search-results\"] section[data-testid=\"search-tracks-result\"] div[role=\"row\"]:nth-child(1) div[data-testid=\"tracklist-row\"] button[data-testid=\"more-button\"]");
        assertTrue(methods.isElementVisible(moreButtonBy,30));
        assertTrue(methods.isElementClickable(moreButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(moreButtonBy);
    }


    public void hoverAddToPlayList(){

        By addPlaylistButtonBy = By.xpath("//span[text()=\"Çalma listesine ekle\"]/parent::button");
        assertTrue(methods.isElementVisible(addPlaylistButtonBy,30));
        assertTrue(methods.isElementClickable(addPlaylistButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.hoverElement(methods.findElement(addPlaylistButtonBy));
    }

    public void createPlaylistFromDropdown(){

        By createPlaylistButtonBy = By.xpath("//span[text()='Çalma listesi oluştur']/parent::button");
        assertTrue(methods.isElementVisible(createPlaylistButtonBy, 30),
                createPlaylistButtonBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(createPlaylistButtonBy, 30),
                createPlaylistButtonBy.toString() + " elementi tıklanabilir değil");
        methods.click(createPlaylistButtonBy);
    }

    public void clickCreatedPlaylist(){

        By createdPlaylistBy = By.cssSelector("div[role=\"button\"]:nth-child(1)");
        assertTrue(methods.isElementVisible(createdPlaylistBy, 30),
                createdPlaylistBy.toString() + " elementi görünür değil");
        assertTrue(methods.isElementClickable(createdPlaylistBy, 30),
                createdPlaylistBy.toString() + " elementi tıklanabilir değil");
        methodsUtil.waitByMilliSeconds(300);
        methods.click(createdPlaylistBy);
    }
}
