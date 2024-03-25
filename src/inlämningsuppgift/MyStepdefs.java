import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.*;

public class MyStepdefs {


    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I'm on the registration page of Basketball England on browser {string}")
    public void iMOnTheRegistrationPageOfBasketballEngland(String browser) {

        // Öppna webbläsaren baserat på det angivna alternativet
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
        }

        // Gå till registreringssidan för Basketball England
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

        // Vänta på att sidan ska laddas klart
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @And("I fill all the required registration fields")
    public void iFillAllTheRequiredRegistrationFields() {

        // Generera en slumpmässig e-postadress
        int min = 1;
        int max = 1000000;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;

        // Fyll i födelsedatum
        driver.findElement(By.id("dp")).sendKeys("30/05/1988");

        // Fyll i e-postadress och bekräfta e-postadress
        WebElement mailAdress = driver.findElement(By.cssSelector("#member_emailaddress"));
        String email = "maria" + rand + "@myway.com";
        mailAdress.sendKeys(email);

        //Vi skickar samma värde (mail) till fältet där vi bekräftar mail adressen
        WebElement confirmMailAdress = driver.findElement(By.cssSelector("#member_confirmemailaddress"));
        confirmMailAdress.sendKeys(email);

        // Klicka på accept-fälten för villkor
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label > span.box")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#signup_form > div.form-actions.noborder > input")));
    }

    @And("I fill in {string} and {string}")
    public void iFillInAnd(String firstName, String lastName) {

        // Fyll i förnamn och efternamn
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);

    }

    @When("I accept the terms and conditions {string}")
    public void iAcceptTheTermsAndConditions(String accept) {
        try {
            WebElement termsAndConditions = driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) > label"));
            if (accept.equalsIgnoreCase("true")) {
                termsAndConditions.click();
            } else if (accept.equalsIgnoreCase("false")) {
                // gör ingenting
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // Fyll i lösenord
    @And("I enter a password {string}")
    public void iEnterAPassword(String password) {
        WebElement userPass = driver.findElement(By.id("signupunlicenced_password"));
        userPass.sendKeys(password);
    }

    @And("I confirm the password {string}")
    public void iConfirmThePassword(String password) throws InterruptedException {

        // Bekräfta lösenordet
        driver.findElement(By.cssSelector("#signupunlicenced_confirmpassword")).sendKeys(password);
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box"));

        Thread.sleep(20);
    }


    @And("I click the {string}")
    public void iClickThe(String JOIN) {

        // Klicka på "JOIN" -knappen för att skicka in registreringen
        driver.findElement(By.cssSelector("#signup_form > div.form-actions.noborder > input")).submit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bold:nth-child(1)")));
    }

    @Then("I should receive a message indicating {string}")
    public void iShouldReceiveAMessageIndicating(String messageType) {

        // Kontrollera meddelandetypen och verifiera att det visas korrekt
        String sameCssSelector = ".warning";

        if (messageType.equals(".bold:nth-child(1)")) {
            WebElement confirmation = driver.findElement(By.className(".bold:nth-child(1)"));
            String confirmationMessage = confirmation.getText();
            assertEquals("THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND", confirmationMessage);


        } else if (messageType.equals(sameCssSelector)) {
            List<WebElement> warningElements = driver.findElements(By.cssSelector(messageType));
            assertTrue("Expected at least one warning message to be displayed", !warningElements.isEmpty());

        }

    }
}
