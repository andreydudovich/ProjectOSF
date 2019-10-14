package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementsUtil;

public class LoanApplicationPage {

    RemoteWebDriver driver;

    protected final String LOAN_AMOUNT = "input_2_1";
    protected final String REPAYABLE_DATE = "#input_2_16";
    protected final String LOAN_PURPOSE = "#input_2_16"; //By.name("input_14")
    protected final String TITLE = "input_2_3";
    protected final String CHECK_BOX_SUBMIT = "input_15.1";
    protected final String SUBMIT_REQUEST = "gform_submit_button_2";
    protected final String FIRST_NAME = "input_2_4";
    protected final String SURNAME = "input_2_5";
    protected final String ID_NUMBER = "input_2_2";
    protected final String PHONE_NUMBER = "input_2_6";
    protected final String EMAIL = "input_2_7";

    //css selector
    @FindBy(css = REPAYABLE_DATE)
    protected WebElement repayableDate;

    @FindBy(css = LOAN_PURPOSE)
    protected WebElement loanPurpose;

    //name
    @FindBy(name = CHECK_BOX_SUBMIT)
    protected WebElement checkBoxSubmit;

    //id
    @FindBy(id = LOAN_AMOUNT)
    protected WebElement loanAmount;

    @FindBy(id = TITLE)
    protected WebElement title;

    @FindBy(id = SUBMIT_REQUEST)
    protected WebElement submitRequest;

    @FindBy(id = FIRST_NAME)
    protected WebElement firstName;

    @FindBy(id = SURNAME)
    protected WebElement surname;

    @FindBy(id = ID_NUMBER)
    protected WebElement idNumber;

    @FindBy(id = PHONE_NUMBER)
    protected WebElement phoneNumber;

    @FindBy(id = EMAIL)
    protected WebElement email;

    public LoanApplicationPage(RemoteWebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    @Step("Set Loan Amount")
    public LoanApplicationPage setLoanAmount(String amount) {
        new ElementsUtil().sendKeysJs(By.id(LOAN_AMOUNT), amount, driver);
        return this;
    }

    @Step("Set Date")
    public LoanApplicationPage setRepayableDate(String date) {
        repayableDate.click();
        String xpath = "//a[@class='ui-state-default' and text() = '" + date + "']";
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    @Step("Set Purpose")
    public LoanApplicationPage setPurpose(String purpose) {
        loanPurpose.click();
        String xpath = "//option[@value='" + purpose + "']";
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    @Step("Set Title")
    public LoanApplicationPage setTitle(String mr) {
        title.click();
        String xpath = "//option[@value='" + mr + "']";
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    @Step("Set First Name")
    public LoanApplicationPage setFirstName(String name) {
        new ElementsUtil().sendKeysJs(By.id(FIRST_NAME), name, driver);
        return this;
    }

    @Step("Set Surname")
    public LoanApplicationPage setSurname(String surname) {
        new ElementsUtil().sendKeysJs(By.id(SURNAME), surname, driver);
        return this;
    }

    @Step("Set ID Number")
    public LoanApplicationPage setIdNumber(String id_number) {
        new ElementsUtil().sendKeysJs(By.id(ID_NUMBER), id_number, driver);
        return this;
    }

    @Step("Set Phone Number")
    public LoanApplicationPage setPhoneNumber(String number) {
        new ElementsUtil().sendKeysJs(By.id(PHONE_NUMBER), number, driver);
        return this;
    }

    @Step("Set Email")
    public LoanApplicationPage email(String email) {
        new ElementsUtil().sendKeysJs(By.id(EMAIL), email, driver);
        return this;
    }

    @Step("Click checkbox submit")
    public LoanApplicationPage checkBoxSubmit() {
        new ElementsUtil().clickJs(By.name(CHECK_BOX_SUBMIT), driver);
        return this;
    }

    @Step("Click submit button")
    public void submitRequest() {
        submitRequest.click();
    }
}