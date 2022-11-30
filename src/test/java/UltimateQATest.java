import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UltimateQATest extends BaseUITest {

    @Test
    public void testOne() {
        WebElement buttonClickUsingId = driver.findElement(By.id("idExample"));
        Assertions.assertTrue(buttonClickUsingId.isDisplayed());
        buttonClickUsingId.click();
    }

    @Test
    public void testTwo() {

        WebDriverWait wait = new WebDriverWait(driver, 10);


        WebElement nameTextField = driver.findElement(By.id("et_pb_contact_name_0"));
        nameTextField.sendKeys("Tomek");

        WebElement emailTextField = driver.findElement(By.id("et_pb_contact_email_0"));
        emailTextField.sendKeys("test@email.com");

        WebElement emailMeButton = driver.findElement(By.xpath("//button[@name='et_builder_submit_button']"));
        wait.until(ExpectedConditions.elementToBeClickable(emailMeButton));
        emailMeButton.click();

        wait.until(ExpectedConditions.invisibilityOf(emailMeButton));
        WebElement thanksForContactingUsText = driver.findElement(By.xpath("//div[@id='et_pb_contact_form_0']//p"));

        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='et_pb_contact_form_0']//p"), "Thanks for contacting us"));
        Assertions.assertEquals("Thanks for contacting us", thanksForContactingUsText.getText());
    }

}
