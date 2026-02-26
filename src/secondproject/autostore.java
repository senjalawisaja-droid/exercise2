package secondproject;

import java.util.List;
import java.util.Random;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class autostore {

	String MywebSite = "https://automationteststore.com/";

	WebDriver driver = new EdgeDriver();
	Random rand = new Random();
	String PasswordAndConfirmPassword = "sttdty985@#$6";
	@BeforeTest

	public void sauce2() throws InterruptedException {

		driver.get(MywebSite);
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void Signup() throws InterruptedException {

		WebElement SignUp = driver.findElement(By.linkText("Login or register"));
		SignUp.click();

		WebElement Continue = driver.findElement(By.xpath("//button[@title='Continue']"));
		Continue.click();

		String[] FemaleNames = { "Noor", "Layan", "Reem", "Sara", "Maryam", "Tala", "Joud", "Haya", "Rana", "Dana" };
		String[] MaleNames = { "Ahmad", "Mohammad", "Omar", "Yousef", "Khaled", "Tareq", "Zaid", "Hassan", "Laith",
				"Sami" };

		int randomindex = rand.nextInt(FemaleNames.length);
		int randomindex2 = rand.nextInt(MaleNames.length);

		String RandomeFirstName = FemaleNames[randomindex];
		String RandomeLastName = MaleNames[randomindex2];

		WebElement FirstNameInput = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement LastNameInput = driver.findElement(By.id("AccountFrm_lastname"));

		FirstNameInput.sendKeys(RandomeFirstName);
		LastNameInput.sendKeys(RandomeLastName);

		int RandomEmailNumber1 = rand.nextInt(5565);
		int RandomEmailNumber2 = rand.nextInt(32155);

		String Email = RandomeFirstName + RandomeLastName + RandomEmailNumber1 + RandomEmailNumber2 + "@gmail.com";
		WebElement EmailInputfield = driver.findElement(By.id("AccountFrm_email"));
		EmailInputfield.sendKeys(Email);

		WebElement AddressInputFeild = driver.findElement(By.id("AccountFrm_address_1"));
		AddressInputFeild.sendKeys("amman");

	

		WebElement CountryDropDown = driver.findElement(By.id("AccountFrm_country_id"));
		Select CountrySelect = new Select(CountryDropDown);
		int RandomCountryDropDown = rand.nextInt(1, 20);
		CountrySelect.selectByIndex(RandomCountryDropDown);

		System.out.println("the country number is " + RandomCountryDropDown);
		String countryName = CountrySelect.getFirstSelectedOption().getText();
		System.out.println("Selected country: " + countryName);
		Thread.sleep(1000);

		WebElement regionDropDown = driver.findElement(By.id("AccountFrm_zone_id"));
		int RandomRegion = rand.nextInt(1,regionDropDown.findElements(By.tagName("option")).size());
		Select RegionSelect = new Select(regionDropDown);
		RegionSelect.selectByIndex(RandomRegion);
		System.out.println("the region number is " + RandomRegion);

		String RegionName = RegionSelect.getFirstSelectedOption().getText();
		System.out.println("Selected region: " + RegionName);
		WebElement cityInputFeild = driver.findElement(By.id("AccountFrm_city"));
		cityInputFeild.sendKeys("RANDOME");
		WebElement PostCode = driver.findElement(By.id("AccountFrm_postcode"));
		PostCode.sendKeys("00000");
		WebElement LoginInput = driver.findElement(By.id("AccountFrm_loginname"));
		LoginInput.sendKeys(RandomeFirstName+RandomeLastName+RandomEmailNumber1+RandomEmailNumber2);
		WebElement Password = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirm = driver.findElement(By.id("AccountFrm_confirm"));
		Password.sendKeys(PasswordAndConfirmPassword);
		PasswordConfirm.sendKeys(PasswordAndConfirmPassword);
		WebElement ChickBox = driver.findElement(By.id("AccountFrm_agree"));
		ChickBox.click();
	
		Thread.sleep(1000);
		WebElement ContinueButton = driver.findElement(By.xpath("//button[@title='Continue']"));
		ContinueButton.click(); 
		
	}
	@Test (priority = 2)
	public void Confirm(){
		
		Assert.assertEquals(driver.getCurrentUrl().contains("success"), true);
		
		
		
		
	}
	@AfterTest(enabled = false)
	public void finish() {

		driver.quit();

	}

}
