package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRole_Page_Objects {
	
	@FindBy(id="menu_admin_viewAdminModule")
	public static WebElement adminTab;
	
	@FindBy(id="menu_admin_UserManagement")
	public static WebElement userManagemnetTab;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public static WebElement usersTab;
	
	@FindBy(id="searchSystemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id="searchSystemUser_status")
	public static WebElement userStatus;
	
	@FindBy(id="searchSystemUser_userName")
	public static WebElement userName;
	
	@FindBy(id="searchBtn")
	public static WebElement searchButton;
	
	@FindBy(xpath="//tr//td[3]")
	public static WebElement userRoleValue;
	
	@FindBy(xpath="//tr/td[5]")
	public static WebElement userStatusValue;
	
	
}
