package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.*;

public class BaseTest {

    private static final ISettingsFile ENVIRONMENT = new JsonSettingsFile("configdata.json");
    private static final String URL = ENVIRONMENT.getValue("/url").toString();

    @BeforeClass
    public void setUp() {
        Browser browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(URL);
        browser.waitForPageToLoad();
    }

    @AfterClass
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}