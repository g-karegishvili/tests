package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utilities.FileUploader;

import java.io.File;
import java.util.List;


public class InterestsPage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ICheckBox unselect = elementFactory.getCheckBox(
            By.xpath("//label[@for='interest_unselectall']//span[@class='checkbox__box']"), "unselect");
    private final ILink uploadButton = elementFactory.getLink(By.className(
            "avatar-and-interests__upload-button"), "upload");
    private final IButton nextButton = elementFactory.getButton(By.xpath("//button[text()='Next']"), "Next");
    final String checkBoxLocator = "(//span[@class='checkbox__box'])[%d]";

    public InterestsPage() {
        super(By.className("avatar-and-interests__interests-list"), "Interests Page");
    }

    public boolean interestsPageOpened() {
        return state().waitForDisplayed();
    }

    public void selectRandomInterests(List<Integer> indexes) {
        unselect.check();
        for (int i : indexes) {
            final String checkboxesLocator = String.format(checkBoxLocator, i);
            ICheckBox checkbox = elementFactory.getCheckBox(By.xpath(checkboxesLocator), "interest");
            checkbox.check();
        }
    }

    public void uploadImage(File image) throws Exception {
        uploadButton.click();
        FileUploader.uploadFile(image);
    }

    public void submit() {
        nextButton.clickAndWait();
    }
}
