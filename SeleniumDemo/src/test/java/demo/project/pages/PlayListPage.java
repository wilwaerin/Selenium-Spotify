package demo.project.pages;

import demo.project.methods.Methods;
import demo.project.methods.MethodsUtil;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class PlayListPage {

    Methods methods;
    MethodsUtil methodsUtil;

    public PlayListPage(){

        methods = new Methods();
        methodsUtil = new MethodsUtil();
    }

    public void clickPlaylistNameArea(){

        By playlistNameBy = By.cssSelector("section[data-testid='playlist-page'] span[data-testid='entityTitle'] > button");
        assertTrue(methods.isElementVisible(playlistNameBy,30));
        assertTrue(methods.isElementClickable(playlistNameBy,30));
        methods.click(playlistNameBy);
    }

    public void playlistEditDetailsControl(){

        assertTrue(methods.isElementVisible(By.cssSelector("input[data-testid='playlist-edit-details-name-input']"),30));
        assertTrue(methods.isElementVisible(By.cssSelector("textarea[data-testid='playlist-edit-details-description-input']"),30));
        assertTrue(methods.isElementVisible(By.cssSelector("button[data-testid='playlist-edit-details-save-button']"),30));
    }

    public void changePlayListName(String playlistName){

        By playlistNameEditDetailsBy = By.cssSelector("input[data-testid='playlist-edit-details-name-input']");
        methods.clear(playlistNameEditDetailsBy);
        methods.sendKeys(playlistNameEditDetailsBy, playlistName);
        By saveButtonBy = By.cssSelector("button[data-testid='playlist-edit-details-save-button']");
        assertTrue(methods.isElementVisible(saveButtonBy,30));
        assertTrue(methods.isElementClickable(saveButtonBy,30));
        methods.click(saveButtonBy);
        assertTrue(methods.isElementInvisible(playlistNameEditDetailsBy,30));
    }

    public void playlistNameControl(String expectedPlaylistName){

        By playListNameTextBy = By.cssSelector("section[data-testid='playlist-page'] span[data-testid='entityTitle'] > button h1");
        assertTrue(methods.isElementVisible(playListNameTextBy,30));
        String actualPlaylistName = methods.getText(playListNameTextBy);
        assertEquals(expectedPlaylistName, actualPlaylistName,"playlist name eşleşmedi");
    }

    public void clickPlayButton(){
        By playlistNameBy = By.cssSelector("span[class='ButtonInner-sc-14ud5tc-0 iPiseC encore-bright-accent-set']");
        assertTrue(methods.isElementVisible(playlistNameBy,30));
        assertTrue(methods.isElementClickable(playlistNameBy,30));
        methods.click(playlistNameBy);
    }

    public void clickStopButton(){
        By YollaSongBy = By.cssSelector("div[data-testid=\"tracklist-row\"]:nth-child(1)");
        assertTrue(methods.isElementVisible(YollaSongBy,30));
        methodsUtil.waitByMilliSeconds(500);
        methods.hoverElement(methods.findElement(YollaSongBy));
        By stopButtonBy = By.cssSelector("button[class='RfidWIoz8FON2WhFoItU']");
        assertTrue(methods.isElementVisible(stopButtonBy,30));
        assertTrue(methods.isElementClickable(stopButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(stopButtonBy);
    }

    public void deleteSongFromPlaylist(){
        By YollaSongBy = By.cssSelector("div[data-testid=\"tracklist-row\"]:nth-child(1)");
        assertTrue(methods.isElementVisible(YollaSongBy,30));
        methodsUtil.waitByMilliSeconds(500);
        methods.hoverElement(methods.findElement(YollaSongBy));
        By moreButtonBy = By.cssSelector("button[class='T0anrkk_QA4IAQL29get mYN_ST1TsDdC6q1k1_xs']");
        assertTrue(methods.isElementVisible(moreButtonBy,30));
        assertTrue(methods.isElementClickable(moreButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(moreButtonBy);
        By stopButtonBy = By.xpath("//span[text()='Bu çalma listesinden kaldır']");
        assertTrue(methods.isElementVisible(stopButtonBy,30));
        assertTrue(methods.isElementClickable(stopButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(stopButtonBy);
    }

    public void controlDeletedSong(){
        methodsUtil.waitByMilliSeconds(300);
        By deletedSong = By.xpath("//*[@id=\"main\"]/div/div[2]/div[4]/div[1]/div[2]/div[2]/div/div/div[2]/main/div[1]/section/div[2]/div[3]/div[1]/div[2]/div[2]/div/div");
        assertFalse(methods.isElementClickable(deletedSong,30));
    }

    public void deletePlaylistFromPlaylistPage(){
        By ThreeDotBy = By.cssSelector("button[class='T0anrkk_QA4IAQL29get']");
        assertTrue(methods.isElementVisible(ThreeDotBy,30));
        assertTrue(methods.isElementClickable(ThreeDotBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(ThreeDotBy);
        By DeleteButtonBy = By.xpath("//span[text()='Sil']/parent::button");
        assertTrue(methods.isElementVisible(DeleteButtonBy,30));
        assertTrue(methods.isElementClickable(DeleteButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(DeleteButtonBy);
        By ModalDeleteButtonBy = By.cssSelector("span[class='ButtonInner-sc-14ud5tc-0 drfsaJ encore-bright-accent-set']");
        assertTrue(methods.isElementVisible(ModalDeleteButtonBy,30));
        assertTrue(methods.isElementClickable(ModalDeleteButtonBy,30));
        methodsUtil.waitByMilliSeconds(300);
        methods.click(ModalDeleteButtonBy);
    }

    public void controlDeletedPlaylist(){
        methodsUtil.waitByMilliSeconds(300);
        By deletedPlaylistBy = By.xpath("//span[@class='ListRowTitle__LineClamp-sc-1xe2if1-0 doJkPH' and text()='Yolla']/parent::p");
        assertFalse(methods.isElementClickable(deletedPlaylistBy, 30));
    }
}
