package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.Attributes;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SignUpPage extends Form {

    private final static IElementFactory elementFactory = AqualityServices.getElementFactory();
    private final ITextBox password = elementFactory.getTextBox(
            By.xpath("//input[contains(@placeholder, 'Password')]"), "password");
    private final ITextBox emailBody = elementFactory.getTextBox(
            By.xpath("//input[contains(@placeholder, 'email')]"), "email body");
    private final ITextBox emailDomain = elementFactory.getTextBox(
            By.xpath("//input[contains(@placeholder, 'Domain')]"), "email domain");
    private final ILabel emailExtSelector = elementFactory.getLabel(
            By.className("dropdown__field"), "extension selector");
    private final ILabel emailExt = elementFactory.getLabel(By.xpath("//div[text()='.org']"), "extension");
    private final ICheckBox checkBox = elementFactory.getCheckBox(By.className("checkbox__box"), "checkbox");
    private final ILink nextPage = elementFactory.getLink(By.xpath("//a[text()='Next']"), "Next");
    private final IButton acceptCookiesBtn = elementFactory.getButton(
            By.xpath("//button[contains(text(), 'Not')]"), "accept Cookies");
    private final ILabel cookies = elementFactory.getLabel(By.xpath("//div[@class='cookies']"), "cookies");
    private static final IButton hideHelpBtn = elementFactory.getButton(
            By.xpath("//button[contains(@class, 'send-to-bottom')]"), "hide help");
    private final static ILabel helpBar = elementFactory.getLabel(By.className("help-form"), "help bar");
    private final ILabel timer = elementFactory.getLabel(
            By.xpath("//div[contains(@class, 'timer--center')]"), "timer");

    public SignUpPage() {
        super(By.xpath("//div[text()='1 / 4']"), "sign up page");
    }

    public boolean signUpPageOpened() {
        return state().waitForDisplayed();
    }

    public void fillPassword(String randPass) {
        password.clearAndType(randPass);
    }

    public void fillMailBody(String mailBody) {
        emailBody.clearAndType(mailBody);
    }

    public void fillDomain(String domain) {
        emailDomain.clearAndType(domain);
    }

    public void selectExtension() {
        emailExtSelector.click();
        emailExt.click();
    }

    public void acceptTOS() {
        checkBox.check();
    }

    public void submit() {
        nextPage.clickAndWait();
    }

    public String getHelpBarClassName() {
        return helpBar.getAttribute(Attributes.CLASS.toString());
    }

    public void clickHideBtn(){hideHelpBtn.clickAndWait();}

    public void acceptCookies() {
        acceptCookiesBtn.clickAndWait();
    }

    public boolean cookiesTabDisappeared() {
        return cookies.state().waitForNotExist();
    }

    public String getTime() {
        return timer.getText();
    }
}