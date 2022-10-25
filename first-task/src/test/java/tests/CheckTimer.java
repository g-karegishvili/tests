package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;

public class CheckTimer extends BaseTest {

    @Test
    public void checkTimer() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageOpen(), "Main page was not opened");
        mainPage.goToNextLevel();
        SignUpPage signUpPage = new SignUpPage();
        Assert.assertTrue(signUpPage.signUpPageOpened(), "Second page was not opened");
        ISettingsFile environment = new JsonSettingsFile("testdata.json");
        Assert.assertEquals(signUpPage.getTime(), environment.getValue("/initial_time").toString(),
                "timer was not restarted");
    }
}