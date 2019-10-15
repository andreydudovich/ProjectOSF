package test;

import dataProviders.LoanRequestDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoanApplicationPage;
import pages.LoanRequestReceivedPage;
import pages.PowWowloansHomePage;

public class LoanRequestTest extends LoanRequestTestBase {
    private static final Logger LOG = LoggerFactory.getLogger(PowWowloansHomePage.class);

    RemoteWebDriver driver;
    LoanRequestReceivedPage loanRequestReceivedPage;

    private final String LOANAMOUNT_DEFAULT = "500";
    private final String FIRST_NAME = "John";
    private final String SURNAME = "Smith";
    private final String ID_NUMBER = "9202204720082";
    private final String PHONE_NUMBER = "0817874692";
    private final String EMAIL = "roma.sucre1@gmail.com";
    private final String CURRENT_MONTH_30 = "30";
    private final String EDUCATION = "Education";
    private final String MR = "Mr";
    private final String THANK_YOU_TEXT = "Thank You for Applying with Pow Wow Loans";
    private final String NOTIFICATION_TEXT = "Once we receive all your documents and it gets processed " +
            "one of our consultants will give you call on your loan approval.";

    @BeforeTest
    public void beforeTest(){
        LOG.info("Getting ChromeDriver location");
        System.setProperty("webdriver.chrome.driver" ,  "/Users/adudovics/chromedriver");
        LOG.info("Initializing ChromeDriver");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest(){
        LOG.info("Closing ChromeDriver");
        driver.close();
    }

    @Story("Loan limits test")
    @Description("1. Go to the main page of https://powwowloans.co.za/\n" +
            "2. Press Apply Now button.\n" +
            "3. Enter all needed fields with amount {{}} and press submit.\n" +
            "4. Check that successful message is shown and your request has been sent.")
    @Test(dataProvider = "loanLimits", dataProviderClass = LoanRequestDataProvider.class)
    public void loanLimitsTest(String loanLimit) {
        loanRequestReceivedPage = new LoanRequestReceivedPage(driver);

        new PowWowloansHomePage(driver).open()
                .clickApplyNow();

        new LoanApplicationPage(driver).setLoanAmount(loanLimit)
                .setRepayableDate(CURRENT_MONTH_30)
                .setPurpose(EDUCATION)
                .setTitle(MR)
                .setFirstName(FIRST_NAME)
                .setSurname(SURNAME)
                .setIdNumber(ID_NUMBER)
                .setPhoneNumber(PHONE_NUMBER)
                .email(EMAIL)
                .checkBoxSubmit().submitRequest();

        checkSuccessfulLoanRequest(loanRequestReceivedPage, THANK_YOU_TEXT, NOTIFICATION_TEXT);
    }

    @Story("Loan purpose test")
    @Description("1. Go to the main page of https://powwowloans.co.za/\n" +
            "2. Press Apply Now button.\n" +
            "3. Enter all needed fields with purposes {{}} and press submit.\n" +
            "4. Check that successful message is shown and your request has been sent.")
    @Test(dataProvider = "loanPurposes", dataProviderClass = LoanRequestDataProvider.class)
    public void loanPurposesTest(String loanPurpose) {
        loanRequestReceivedPage = new LoanRequestReceivedPage(driver);

        new PowWowloansHomePage(driver).open()
                .clickApplyNow();

        new LoanApplicationPage(driver).setLoanAmount(LOANAMOUNT_DEFAULT)
                .setRepayableDate(CURRENT_MONTH_30)
                .setPurpose(loanPurpose)
                .setTitle(MR)
                .setFirstName(FIRST_NAME)
                .setSurname(SURNAME)
                .setIdNumber(ID_NUMBER)
                .setPhoneNumber(PHONE_NUMBER)
                .email(EMAIL)
                .checkBoxSubmit().submitRequest();

        checkSuccessfulLoanRequest(loanRequestReceivedPage, THANK_YOU_TEXT, NOTIFICATION_TEXT);
    }
}
