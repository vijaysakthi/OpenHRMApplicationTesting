package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonFunctions;
import pageObjects.Dashboard_Page_Objects;
import pageObjects.Login_Page_Objects;

public class Test_Pending_Leave_Request extends CommonFunctions {
	
	String actualMessage;
	Logger logger =Logger.getLogger(Test_Pending_Leave_Request.class);
	
	
	public void login() {
		
		logger.info("Logging in...");
		
		PageFactory.initElements(driver, Login_Page_Objects.class);
		
		Login_Page_Objects.txtUsername.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.txtPassword.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.btnLogin.click();
	}
	
	public void getPendingLeaveRequest() {
		
		PageFactory.initElements(driver, Dashboard_Page_Objects.class);
		
		actualMessage = Dashboard_Page_Objects.pendingLeaveRquests.getText();
	}

	@Test
	public void verifyPendingLeaveRequest() {
		
		login();
	
		logger.info("Getting PendingLeaveRequest details... ");
		getPendingLeaveRequest();
		
		//Checks if its true using assert,instead of if statment
		Assert.assertEquals(actualMessage, "No Records are Available");
		logger.info(" End of PendingLeaveRequest test case ");
	}

}
