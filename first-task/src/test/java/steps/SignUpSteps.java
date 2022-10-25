package steps;

import pages.SignUpPage;

public class SignUpSteps {

    public static void signUp(String password, String mail, String domain) {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.fillPassword(password);
        signUpPage.fillMailBody(mail);
        signUpPage.fillDomain(domain);
        signUpPage.selectExtension();
        signUpPage.acceptTOS();
        signUpPage.submit();
    }
}