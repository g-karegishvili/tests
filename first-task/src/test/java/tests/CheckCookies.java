package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;

public class CheckCookies extends BaseTest{

    @Test
    public void checkCookies() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageOpen(), "Main page was not opened");
        mainPage.goToNextLevel();
        SignUpPage signUpPage = new SignUpPage();
        Assert.assertTrue(signUpPage.signUpPageOpened(), "Second page was not opened");
        signUpPage.acceptCookies();
        Assert.assertTrue(signUpPage.cookiesTabDisappeared(), "cookies tab didn't disappear");
    }
}
