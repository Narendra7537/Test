package com.uhc.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.uhc.core.BaseClass;

public class HomePage extends BaseClass 
{
	
	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory Design Pattern
	@FindBy(xpath = "//input[@name='searchTerm']")
	WebElement searchBox;
	
	@FindBy(xpath = "")
	WebElement searchButton;
	
	public void searchItem(String searchText)
	{
		searchBox.sendKeys(searchText);
		searchBox.sendKeys(Keys.ENTER);
	}
	
	@FindBy(xpath = "//button[text()='Shop insurance']")
	WebElement shopInsuranceDropdown;
	
	@FindBy(xpath = "//div[text()='Shop insurance']")
	WebElement shopInsuranceHeader;
	
	@FindBy(xpath = "//button[text()='Medicare ']")
	WebElement medicare;
	
	@FindBy(xpath = "//button[text()='Health insurance plans']")
	WebElement healthInsurancePlans;
	
	@FindBy(xpath = "//button[text()='Medicaid']")
	WebElement medicaid;
	
	@FindBy(xpath = "//button[text()='Dental, vision & more']")
	WebElement denatlAndVision;
	
	@FindBy(xpath = "//button[text()='Group plans for employers']")
	WebElement groupPlans;
	
	@FindBy(xpath = "//button[text()='Learn about insurance']")
	WebElement learnAboutInsurance;
	
	@FindBy(xpath = "//a[text()='Shop all plans']")
	WebElement shopAllPlans;
	
	@FindBy(xpath = "//button[text()='Member resources']")
	WebElement memberResourcesDropdown;
	
	@FindBy(xpath = "//div[text()='Resources']")
	WebElement resourcesHeader;
	
	@FindBy(xpath = "//a[text()='Choosing a doctor']")
	WebElement choosingADoctor;
	
	@FindBy(xpath = "//a[text()='Member ID card']")
	WebElement memberIdCard;
	
	@FindBy(xpath = "//a[text()='Pharmacy benefits']")
	WebElement pharmacyBenefits;
	
	@FindBy(xpath = "//a[text()='Forms']")
	WebElement forms;
	
	@FindBy(xpath = "//a[text()='Health & wellness topics']")
	WebElement healthAndWellness;
	
	@FindBy(xpath = "//a[text()='All member resources']")
	WebElement allMemberResources;
	
	@FindBy(xpath = "//div[text()='Programs & tools']")
	WebElement programsAndTools;
	
	@FindBy(xpath = "//a[text()='UHC app']")
	WebElement uhcApp;
	
	@FindBy(xpath = "//a[text()='Rewards programs']")
	WebElement rewardsPrograms;
	
	@FindBy(xpath = "//a[text()='Mental health programs']")
	WebElement mentalHealthPrograms;
	
	@FindBy(xpath = "//a[text()='Virtual visits']")
	WebElement virtualVisits;
	
	@FindBy(xpath = "//a[text()='All member programs']")
	WebElement allMemberPrograms;
	
	String hColorCode ="#002677";
	String colorCode ="#196ECF";
	String lightBlueColorCode = "#E5F8FB";
	public void verifyShopInsuranceElements() throws InterruptedException {
		Thread.sleep(25000);
		shopInsuranceDropdown.click();
		isElementDisplayed(shopInsuranceHeader, "Shop insurance");
		isElementDisplayed(medicare, "Medicare");
		isElementDisplayed(healthInsurancePlans, "Health insurance plans");
		isElementDisplayed(medicaid, "Medicaid");
		isElementDisplayed(denatlAndVision, "Dental, vision & more");
		isElementDisplayed(groupPlans, "Group plans for employers");
		isElementDisplayed(learnAboutInsurance, "Learn about insurance");
		isElementDisplayed(shopAllPlans, "Shop all plans");
//		#002677 rgba(0, 38, 119, 1)
//		#196ECF rgba(25, 110, 207, 1)
		verifyColor(shopInsuranceHeader,"Shop insurance",hColorCode);
		verifyColor(medicare,"Medicare",colorCode);
		verifyColor(healthInsurancePlans,"Health insurance plans",colorCode);
		verifyColor(medicaid,"Medicaid",colorCode);
		verifyColor(denatlAndVision,"Dental, vision & more",colorCode);
		verifyColor(groupPlans,"Group plans for employers",colorCode);
		verifyColor(learnAboutInsurance,"Learn about insurance",colorCode);
		verifyColor(shopAllPlans,"Shop all plans",colorCode);
	}
	
	public void verifyMemberResourcesResources() throws InterruptedException {
		memberResourcesDropdown.click();
		isElementDisplayed(resourcesHeader, "Resources");
		isElementDisplayed(choosingADoctor, "Choosing a doctor");
		isElementDisplayed(memberIdCard, "Member ID card");
		isElementDisplayed(pharmacyBenefits, "Pharmacy benefits");
		isElementDisplayed(forms, "Forms");
		isElementDisplayed(healthAndWellness, "Health & wellness topics");
		isElementDisplayed(allMemberResources, "All member resources");
		
		verifyColor(resourcesHeader,"Resources",hColorCode);
		verifyColor(choosingADoctor,"Choosing a doctor",colorCode);
		verifyColor(memberIdCard,"Member ID card",colorCode);
		verifyColor(pharmacyBenefits,"Pharmacy benefits",colorCode);
		verifyColor(forms,"Forms", "rgba(25, 110, 207, 1)");
		verifyColor(healthAndWellness,"Health & wellness topics",colorCode);
		verifyColor(allMemberResources,"All member resources",hColorCode);
	}
	
	public void verifyMemberResourcesProgramsAndTools() throws InterruptedException {
		isElementDisplayed(programsAndTools, "Programs & tools");
		isElementDisplayed(uhcApp, "UHC app");
		isElementDisplayed(rewardsPrograms, "Rewards programs");
		isElementDisplayed(mentalHealthPrograms, "Mental health programs");
		isElementDisplayed(virtualVisits, "Virtual visits");
		isElementDisplayed(allMemberPrograms, "All member programs");
		
		verifyColor(programsAndTools,"Programs & tools",hColorCode);
		verifyColor(uhcApp,"UHC app",colorCode);
		verifyColor(rewardsPrograms,"Rewards programs",colorCode);
		verifyColor(mentalHealthPrograms,"Mental health programs",colorCode);
		verifyColor(virtualVisits,"Virtual visits",colorCode);
		verifyColor(allMemberPrograms,"All member programs",hColorCode);
		memberResourcesDropdown.click();
	}
	
	public void isElementDisplayed(WebElement element, String Name) throws InterruptedException {
		Thread.sleep(2000);
		if(element.isDisplayed()) {
			Reporter.log(Name+" displayed<br>");
		}else {
			Reporter.log(Name+" not displayed<br>");
		}
		
	}
	
	public void verifyColor(WebElement element,String Name, String colorCode) {
		String color = element.getCssValue("color");
		String[] numbers = color.replace("rgba(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		System.out.println("r: " + r + "g: " + g + "b: " + b);

		String hex = Integer.toHexString(r).toUpperCase() + Integer.toHexString(g).toUpperCase() + Integer.toHexString(b).toUpperCase();
		System.out.println(hex);
		if(colorCode.contains(hex)) {
			Reporter.log(Name+" color verified<br>");
		}else {
			Reporter.log(Name+" incorrect color exist<br>");
		}
		
	}
	
	public void verifyShopInsuranceAndMemberResourcesLinksPresentonceApplicationOpens() throws InterruptedException {
		isElementDisplayed(shopInsuranceDropdown, "Shop insurance");
		isElementDisplayed(memberResourcesDropdown, "Member resources");
		
	}
	
	@FindBy(xpath = "//a[text()='Medicare Advantage plans']")
	WebElement medicareAdvantagePlans;
	
	@FindBy(xpath = "//a[text()='Medicare supplement plans']")
	WebElement medicareSupplementPlans;
	
	@FindBy(xpath = "//a[text()='Medicare prescription drug plans']")
	WebElement medicarePrescriptionDrugPlans;
	
	@FindBy(xpath = "//a[text()='Dual Special Needs plan (D-SNP)']")
	WebElement dualSpecialNeedsPlan;
	
	@FindBy(xpath = "//a[text()='Shop all Medicare plans']")
	WebElement shopAllMedicarePlans;
	
	@FindBy(xpath = "(//a[text()='Help me find a plan'])[1]")
	WebElement helpMeFindAPlan;
	
	@FindBy(xpath = "//a[text()='Estimate drug costs']")
	WebElement estimateDrugCosts;
	
	@FindBy(xpath = "//a[text()='Search for a pharmacy']")
	WebElement searchForAPharmacy;
	
	@FindBy(xpath = "(//a[text()='Find a doctor'])[1]")
	WebElement findADoctor;
	
	@FindBy(xpath = "//a[text()='Find a dentist']")
	WebElement findADentist;
	
	@FindBy(xpath = "//a[text()='Medicare overview']")
	WebElement medicareOverview;
	
	public void verifyMedicareLinks() throws InterruptedException {
		medicare.click();
		verifyBackgroundColor(medicare,"Medicare",lightBlueColorCode);
		verifyPadding(medicare,"Medicare",padding);
		isElementDisplayed(medicareAdvantagePlans, "Medicare Advantage plans");
		isElementDisplayed(medicareSupplementPlans, "Medicare supplement plans");
		isElementDisplayed(medicarePrescriptionDrugPlans, "Medicare prescription drug plans");
		isElementDisplayed(dualSpecialNeedsPlan, "Dual Special Needs plan (D-SNP)");
		isElementDisplayed(shopAllMedicarePlans, "Shop all Medicare plans");
		isElementDisplayed(helpMeFindAPlan, "Help me find a plan");
		isElementDisplayed(estimateDrugCosts, "Estimate drug costs");
		isElementDisplayed(searchForAPharmacy, "Search for a pharmacy");
		isElementDisplayed(findADoctor, "Find a doctor");
		isElementDisplayed(findADentist, "Find a dentist");
		isElementDisplayed(medicareOverview, "Medicare overview");
	}
	
	@FindBy(xpath = "//a[text()='Short term plans']")
	WebElement shortTermPlans;
	
	@FindBy(xpath = "//a[text()='ACA marketplace plans']")
	WebElement acaMarketplacePlans;
	
	@FindBy(xpath = "//a[text()='Plans through work']")
	WebElement plansThroughWork;
	
	@FindBy(xpath = "//a[text()='All health insurance plans']")
	WebElement allHealthInsurancePlans;
	
	@FindBy(xpath = "//a[text()='Short term vs. ACA plans']")
	WebElement shortTermACAPlans;
	
	@FindBy(xpath = "//a[text()='Open enrollment']")
	WebElement openEnrollment;
	
	@FindBy(xpath = "//a[contains(text(),'Qualifying life events')]")
	WebElement qualifyingLifeEvents;
	
	@FindBy(xpath = "//a[text()='Medicaid renewal']")
	WebElement medicalRenewal;
	
	public void verifyHelathInsurancePlansLinks() throws InterruptedException {
		healthInsurancePlans.click();
		verifyBackgroundColor(healthInsurancePlans,"Health insurance plans",lightBlueColorCode);
		verifyPadding(healthInsurancePlans,"Health insurance plans",padding);
		isElementDisplayed(shortTermPlans, "Short term plans");
		isElementDisplayed(acaMarketplacePlans, "ACA marketplace plans");
		isElementDisplayed(plansThroughWork, "Plans through work");
		isElementDisplayed(allHealthInsurancePlans, "All health insurance plans");
		isElementDisplayed(shortTermACAPlans, "Short term vs. ACA plans");
		isElementDisplayed(openEnrollment, "Open enrollment");
		isElementDisplayed(qualifyingLifeEvents, "Qualifying life events");
		isElementDisplayed(medicalRenewal, "Medicaid renewal");
	}
	
	
	@FindBy(xpath = "//a[text()='Medicaid plans']")
	WebElement medicaidPlans;
	
	@FindBy(xpath = "//a[text()='Dual Special Needs plans (D-SNP)']")
	WebElement dualSpecialNeedsPlans;
	
	@FindBy(xpath = "//a[text()='Children’s Health Insurance plans (CHIP)']")
	WebElement childrensHealthInsurancePlans;
	
	@FindBy(xpath = "//a[text()='Try our plan eligibility tool']")
	WebElement tryOurPlanEligibilityTool;
	
	public void verifyMedicaidLinks() throws InterruptedException {
		medicaid.click();
		verifyBackgroundColor(medicaid,"Medicaid",colorCode);
		verifyPadding(medicaid,"Medicaid",padding);
		isElementDisplayed(medicaidPlans, "Medicaid plans");
		isElementDisplayed(dualSpecialNeedsPlans, "Dual Special Needs plans (D-SNP)");
		isElementDisplayed(childrensHealthInsurancePlans, "Children’s Health Insurance plans (CHIP)");
		isElementDisplayed(tryOurPlanEligibilityTool, "Try our plan eligibility tool");
	}
	
	@FindBy(xpath = "//a[text()='Shop all supplemental plans']")
	WebElement shopAllSupplementalPlans;
	
	@FindBy(xpath = "//a[contains(text(),'Dental insurance')]")
	WebElement dentalInsurance;
	
	@FindBy(xpath = "//a[text()='Vision insurance']")
	WebElement visionInsurance;
	
	@FindBy(xpath = "//a[text()='Accident insurance']")
	WebElement accidentInsurance;
	
	@FindBy(xpath = "//a[text()='Critical illness insurance']")
	WebElement criticalIllnessInsurance;
	
	@FindBy(xpath = "//a[contains(text(),'Hospital & doctor fixed indemnity insurance')]")
	WebElement hospitalAndDoctorFixed;
	
	@FindBy(xpath = "//a[text()='Hospitalization insurance']")
	WebElement hospitalizationInsurance;
	
	public void verifyDentalVisionLinks() throws InterruptedException {
		denatlAndVision.click();
		verifyBackgroundColor(denatlAndVision,"Dental, vision & more",lightBlueColorCode);
		verifyPadding(denatlAndVision,"Dental, vision & more",padding);
		isElementDisplayed(shopAllSupplementalPlans, "Shop all supplemental plans");
		isElementDisplayed(dentalInsurance, "Dental insurance");
		isElementDisplayed(visionInsurance, "Vision insurance");
		isElementDisplayed(accidentInsurance, "Accident insurance");
		isElementDisplayed(criticalIllnessInsurance, "Critical illness insurance");
		isElementDisplayed(hospitalAndDoctorFixed, "Hospital & doctor fixed indemnity insurance");
		isElementDisplayed(hospitalizationInsurance, "Hospitalization insurance");
	}
	
	@FindBy(xpath = "(//a[text()='Small business'])[1]")
	WebElement smallBusiness;
	
	@FindBy(xpath = "//a[text()='Large organizations']")
	WebElement largeOrganizations;
	
	@FindBy(xpath = "//a[text()='All group plans for employers']")
	WebElement allGroupPlansForEmployers;
	
	
	public void verifyGroupPlandForEmployersLinks() throws InterruptedException {
		groupPlans.click();
		verifyBackgroundColor(groupPlans,"Group plans for employers",lightBlueColorCode);
		verifyPadding(groupPlans,"Group plans for employers",padding);
		isElementDisplayed(smallBusiness, "Small business");
		isElementDisplayed(largeOrganizations, "Large organizations");
		isElementDisplayed(allGroupPlansForEmployers, "All group plans for employers");
		
	}
	
	@FindBy(xpath = "//a[text()='Understanding health insurance']")
	WebElement understandingHealthInsurance;
	
	@FindBy(xpath = "//a[text()='Managing costs']")
	WebElement managingCosts;
	
	@FindBy(xpath = "(//a[contains(text(),'Medicaid renewal')])[1]")
	WebElement medicaidRenewal;
	
	@FindBy(xpath = "//a[text()='Benefits & coverage']")
	WebElement benefitsAndCoverage;
	
	@FindBy(xpath = "//a[text()='Medicare articles & resources']")
	WebElement medicareArticlesAndResources;
	
	@FindBy(xpath = "//a[text()='Newsroom ']")
	WebElement newsRoom;
	
	@FindBy(xpath = "(//a[text()='All news & articles'])[1]")
	WebElement allNewsAndArticles;
	
	public void verifyLearnAboutInsuranceLinks() throws InterruptedException {
		learnAboutInsurance.click();
		verifyBackgroundColor(learnAboutInsurance,"Learn about insurance",lightBlueColorCode);
		verifyPadding(learnAboutInsurance,"Learn about insurance",padding);
		isElementDisplayed(understandingHealthInsurance, "Understanding health insurance");
		isElementDisplayed(openEnrollment, "Open enrollment");
		isElementDisplayed(qualifyingLifeEvents, "Qualifying life events");
		isElementDisplayed(managingCosts, "Managing costs");
		isElementDisplayed(medicaidRenewal, "Medicaid renewal");
		isElementDisplayed(benefitsAndCoverage, "Benefits & coverage");
		isElementDisplayed(medicareArticlesAndResources, "Medicare articles & resources");
		isElementDisplayed(newsRoom, "Newsroom");
		isElementDisplayed(allNewsAndArticles, "All news & articles");
	}
	
	public void verifyBackgroundColor(WebElement element,String Name, String backGroundColor) {
		String backgroundcolor = element.getCssValue("background").substring(0, 19);
		String[] numbers = backgroundcolor.replace("rgb(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		System.out.println("r: " + r + "g: " + g + "b: " + b);

		String backhex = Integer.toHexString(r).toUpperCase() + Integer.toHexString(g).toUpperCase() + Integer.toHexString(b).toUpperCase();
		System.out.println(backhex);
		if(backGroundColor.contains(backhex)) {
			Reporter.log(Name+" background color verified<br>");
		}else {
			Reporter.log(Name+" incorrect background color exist<br>");
		}
		
	}
	
	String padding = "8px 4px 8px 16px";
	public void verifyPadding(WebElement element, String Name, String padding) {
		String paddingvalue = element.getCssValue("padding");
		if(padding.contains(paddingvalue)) {
			Reporter.log(Name+" padding verified<br>");
		}else {
			Reporter.log(Name+" incorrect padding exist<br>");
		}
		
	}

}
