package dataProviders;

import org.testng.annotations.DataProvider;

public class LoanRequestDataProvider {

    @DataProvider(name = "loanPurposes")
    public static Object[][] purposes() {
        return new Object[][]{
                {"Starting A Business"},
                {"Education"},
                {"Emergency Fund"},
                {"Home Improvements"},
                {"Consolidate Debt"},
                {"Other"}
        };
    }

    @DataProvider(name = "loanLimits")
    public static Object[][] limits() {
        return new Object[][]{
                {"500"},
                {"2000"},
                {"4000"},
        };
    }
}
