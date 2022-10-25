package steps;

import pages.SignUpPage;

public class HelpBarSteps {
    public static boolean helpBarHidden() {
        SignUpPage signUpPage = new SignUpPage();
        String initClassName = signUpPage.getHelpBarClassName();
        signUpPage.clickHideBtn();
        String finalClassName = signUpPage.getHelpBarClassName();
        return !initClassName.equals(finalClassName);
    }
}
