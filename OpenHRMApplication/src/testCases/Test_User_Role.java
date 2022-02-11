package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.CommonFunctions;
import pageObjects.Login_Page_Objects;
import pageObjects.UserRole_Page_Objects;

public class Test_User_Role extends CommonFunctions {
	
	String actualRole,actualStatus;
	Logger logger =Logger.getLogger(Test_User_Role.class);

	public void login() {

		PageFactory.initElements(driver, Login_Page_Objects.class);

		Login_Page_Objects.txtUsername.sendKeys(properties.getProperty("username"));
		Login_Page_Objects.txtPassword.sendKeys(properties.getProperty("password"));
		Login_Page_Objects.btnLogin.click();
	}

	public void moveToUsersTab() {
		//PageFactory.initElements(driver, UserRole_Page_Objects.class);

		Actions actions = new Actions(driver);
		actions.moveToElement(UserRole_Page_Objects.adminTab);
		actions.moveToElement(UserRole_Page_Objects.userManagemnetTab);
		actions.moveToElement(UserRole_Page_Objects.usersTab);
		actions.click().build().perform();
	}
	
	public void selectUserRoleAndStatusToSearch() {
		
		Select selectRole =new Select(UserRole_Page_Objects.userRole);
		selectRole.selectByIndex(1);;
		
		Select selectStatus =new Select(UserRole_Page_Objects.userStatus);
		selectStatus.selectByIndex(1);
		
		UserRole_Page_Objects.searchButton.click();
		
	}

	@Test
	public void checkUserRole() {

		//login();

		PageFactory.initElements(driver, UserRole_Page_Objects.class);
		
		logger.info("Clicks User Tab");
		moveToUsersTab();
		
		logger.info("Selecting UserRole details & entering search");
		selectUserRoleAndStatusToSearch();
		
		actualRole =UserRole_Page_Objects.userRoleValue.getText();
		actualStatus =UserRole_Page_Objects.userStatusValue.getText();
		
		logger.info("Validating the UserRole details");
		Assert.assertEquals(actualRole, "Admin");
		Assert.assertEquals(actualStatus, "Enabled");
		logger.info("End of UserRole test case.");


	}

}
