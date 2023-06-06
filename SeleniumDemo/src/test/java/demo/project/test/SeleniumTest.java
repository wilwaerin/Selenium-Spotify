package demo.project.test;

import demo.project.driver.SeleniumDriver;
import demo.project.methods.Methods;
import demo.project.methods.MethodsUtil;
import demo.project.pages.HomePage;
import demo.project.pages.LoginPage;
import demo.project.pages.PlayListPage;
import demo.project.pages.SearchPage;
import org.junit.jupiter.api.Test;

public class SeleniumTest extends SeleniumDriver {

    HomePage homePage;
    LoginPage loginPage;
    PlayListPage playListPage;
    SearchPage searchPage;
    Methods methods;
    MethodsUtil methodsUtil;

    public SeleniumTest() {

        methodsUtil = new MethodsUtil();
    }

    @Test
    public void seleniumTest1(){

        // username ve password için yeni Hesap oluşturup yada kendi hesabınızda kullanabilirsiniz
        homePage = new HomePage();
        loginPage = new LoginPage();
        playListPage = new PlayListPage();
        methods = new Methods();
        homePage.homePageControlWithoutLogin();
        homePage.closeOneTrust();
        homePage.oturumAcButonunaTikla();
        loginPage.loginPageControl();
        loginPage.validLogin("teamcrazypirate@gmail.com","crazypiratesbrb");
        homePage.homePageControlWithLogin();
        homePage.usernameControl("crazypirates");
        homePage.createNewPlayList();
        //homePage.clickDismissButton();
        playListPage.clickPlaylistNameArea();
        playListPage.playlistEditDetailsControl();
        String playListName = "New PlayList";
        playListPage.changePlayListName(playListName);
        playListPage.playlistNameControl(playListName);
        methodsUtil.waitBySeconds(4);
    }

    @Test
    public void seleniumTest2(){

        homePage = new HomePage();
        homePage.homePageControlWithoutLogin();
        homePage.closeOneTrust();
        methodsUtil.waitBySeconds(4);
        homePage.dilDegistirButonunaTikla();
        methodsUtil.waitBySeconds(4);
    }

    @Test
    public void playlistTest(){

        homePage = new HomePage();
        loginPage = new LoginPage();
        playListPage = new PlayListPage();
        searchPage = new SearchPage();
        methods = new Methods();
        homePage.homePageControlWithoutLogin();
        homePage.closeOneTrust();
        homePage.oturumAcButonunaTikla();
        loginPage.loginPageControl();
        loginPage.validLogin("teamcrazypirate@gmail.com","crazypiratesbrb");
        homePage.homePageControlWithLogin();
        homePage.usernameControl("crazypirates");
        homePage.clickSearchButton();
        searchPage.search("yolla");
        searchPage.clickTrackMoreButton();
        searchPage.hoverAddToPlayList();
        searchPage.createPlaylistFromDropdown();
        methodsUtil.waitBySeconds(2);
        searchPage.clickCreatedPlaylist();
        playListPage.clickPlayButton();
        methodsUtil.waitBySeconds(10);
        playListPage.clickStopButton();
        playListPage.deleteSongFromPlaylist();
        methodsUtil.waitBySeconds(4);
        playListPage.controlDeletedSong();
        playListPage.deletePlaylistFromPlaylistPage();
        playListPage.controlDeletedPlaylist();
        methodsUtil.waitBySeconds(10);
    }
}
