package com.uhc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.uhc.core.BaseClass;

public class NewsRoomPage extends BaseClass {
	public NewsRoomPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Newsroom']")
	WebElement newsRoomHomePage;
	
	@FindBy(xpath = "(//div[contains(@class,'circle')])[1]")
	WebElement emailIcon;
	
	@FindBy(xpath = "//input[@id=\"email\"]")
	WebElement emailTextbox;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter a valid email address')]")
	WebElement invalidEmailErrMsg;
	
	@FindBy(xpath = "//div[contains(text(),'Thanks for subscribing to our newsletter.')]")
	WebElement successMsg;
	
	String invalidemail="abcdef.ghij";
	String validemail="abc.ijk@gmail.com";
	
	String invalidtext="Please enter a valid email address";
	String validtext="Thanks for subscribing to our newsletter.";
	
	String invalidname = "invalid email id";
	String validname = "valid email id";
			
	public void verifyEmailIdInNewsRoom() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		newsRoomHomePage.click();
		Thread.sleep(10000);
		homepage.isElementDisplayed(emailIcon, "Email Icon");
		verifyEmailid(invalidEmailErrMsg,invalidtext,invalidemail,invalidname,invalidemail);
		verifyEmailid(successMsg,validtext,validemail,validname,validemail);
		
		}
	
	public void verifyEmailid(WebElement element, String text, String email, String Name, String sendtext) throws InterruptedException {
		emailTextbox.clear();
		emailTextbox.sendKeys(sendtext);
		submitButton.click();
		Thread.sleep(3000);
		String text1 = element.getText();
		System.out.println(text1);
		if(text1.contains(text)) {
			Reporter.log(Name+" verified<br>");
		}else{
			Reporter.log(Name+" not verified<br>");
		}
			
	}
}
