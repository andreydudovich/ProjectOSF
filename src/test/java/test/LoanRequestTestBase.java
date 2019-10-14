package test;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pages.LoanRequestReceivedPage;


class LoanRequestTestBase {

    @Step("Validation of successful loan request")
    void checkSuccessfulLoanRequest(LoanRequestReceivedPage loanRequestReceivedPage, String thankYou, String notification) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(loanRequestReceivedPage
                .getThankYouText(), thankYou, "Text is wrong or has errors.");
        softAssert.assertEquals(loanRequestReceivedPage
                .getNotificationText(), notification, "Text is wrong or has errors.");

        softAssert.assertAll();
    }

}
