package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignUpPage;
import steps.HelpBarSteps;

public class CheckHelpForm extends BaseTest {

    @Test
    public void checkHelpForm() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageOpen(), "Main page was not opened");
        mainPage.goToNextLevel();
        SignUpPage signUpPage = new SignUpPage();
        Assert.assertTrue(signUpPage.signUpPageOpened(), "Second page was not opened");
        Assert.assertTrue( HelpBarSteps.helpBarHidden(), "hide bar was not closed");
    }
}