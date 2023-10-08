package com.uhc.tests;
import org.testng.annotations.Test;
import com.uhc.core.BaseClass;
import com.uhc.pages.HomePage;
import com.uhc.pages.NewsRoomPage;

public class InternalUsersTests extends BaseClass{

	@Test
	public void tc1() throws InterruptedException 
	{
		initialize("chrome");
		launchApplication(properties.getProperty("url"));
		Thread.sleep(1000);
		HomePage homepage = new HomePage(driver);
		NewsRoomPage newsroompage = new NewsRoomPage(driver);
		homepage.verifyShopInsuranceAndMemberResourcesLinksPresentonceApplicationOpens();
		homepage.verifyShopInsuranceElements();
		homepage.verifyMedicareLinks();
		homepage.verifyHelathInsurancePlansLinks();
		homepage.verifyMedicaidLinks();
		homepage.verifyDentalVisionLinks();
		homepage.verifyGroupPlandForEmployersLinks();
		homepage.verifyLearnAboutInsuranceLinks();
		homepage.verifyMemberResourcesResources();
		homepage.verifyMemberResourcesProgramsAndTools();
		newsroompage.verifyEmailIdInNewsRoom();
//		homepage.searchItem("Iphone 14");
		Thread.sleep(1000);
		closeApplication();		
	}
	
	

}
