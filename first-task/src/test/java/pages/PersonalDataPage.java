package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDataPage extends Form {

    public PersonalDataPage() {
        super(By.xpath("//div[@class='page-indicator' and text()='3 / 4']"), "Page Three");
    }

    public boolean personalPageOpen() {
        return state().waitForDisplayed();
    }

}
