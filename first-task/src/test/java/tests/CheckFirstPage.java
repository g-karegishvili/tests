package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InterestsPage;
import pages.MainPage;
import pages.PersonalDataPage;
import pages.SignUpPage;
import steps.GetRandomInterests;
import steps.SignUpSteps;
import utilities.RandUtils;

import java.io.File;

public class CheckFirstPage extends BaseTest {

    private static final ISettingsFile environment = new JsonSettingsFile("testdata.json");

    private static final String PASSWORD = RandUtils.getRandomString();
    private static final String MAIL = RandUtils.getRandomString();
    private static final String EXT = RandUtils.getRandomString();
    private static final String IMAGE_PATH = environment.getValue("/image_path").toString();
    private static final File profilePic = new File(IMAGE_PATH);

    @Test
    public void checkNextPage() throws Exception {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.mainPageOpen(), "Main page was not opened");
        mainPage.goToNextLevel();
        SignUpPage signUpPage = new SignUpPage();
        Assert.assertTrue(signUpPage.signUpPageOpened(), "Second page was not opened");
        SignUpSteps.signUp(PASSWORD, MAIL, EXT);
        InterestsPage interestsPage = new InterestsPage();
        Assert.assertTrue(interestsPage.interestsPageOpened(), "Third page was not opened");
        interestsPage.selectRandomInterests(GetRandomInterests.getRandomInterests());;
        interestsPage.uploadImage(profilePic);
        interestsPage.submit();
        PersonalDataPage personalDataPage = new PersonalDataPage();
        Assert.assertTrue(personalDataPage.personalPageOpen());
    }
}
