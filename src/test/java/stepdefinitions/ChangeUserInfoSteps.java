package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.UserInfoPage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ChangeUserInfoSteps {
    UserInfoPage userInfoPage;
    WebDriver driver;


    @Given("^User is logged in to CodersLab shop$")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");
    }

    @When("^User goes to UserInformationPage$")
    public void userGoesToUserInformationPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=identity");
    }

    @And("^User signs up for our newsletter$")
    public void userSignsUpForOurNewsletter() {
        userInfoPage = new UserInfoPage(driver);
        userInfoPage.signInForNewsletter();
    }

    @And("^User saves information$")
    public void userSavesInformation() {
        userInfoPage.submitUserInfo();
    }

    @Then("^User sees \"([^\"]*)\"$")
    public void userSees(String actionMessage) throws IOException {
        Assert.assertEquals(actionMessage, userInfoPage.getUpdateInformation());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss'-screenshot.png'").format(new Date());
        FileUtils.copyFile(scrFile, new File("screenshots/"+fileName));

        driver.quit();
    }
}
