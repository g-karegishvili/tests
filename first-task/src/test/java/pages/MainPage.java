package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final ILink toNextLevel = elementFactory.getLink(By.xpath("//a[text()='HERE']"), "To next level");


    public MainPage() {
        super(By.xpath("//button[text()='NO']"), "Main Page");
    }

    public boolean mainPageOpen() {
        return state().waitForDisplayed();
    }

    public void goToNextLevel() {
        toNextLevel.clickAndWait();
    }


}
