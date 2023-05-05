package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.ETTPage;
import page.LoginPage;

public class ValidLogin1 extends BaseTest 
{
	@Test
	
	public void testvalidLogin()
	{
		String un=Excel.getData(XL_PATH, "ValidLogin", 1, 0);
		String pw=Excel.getData(XL_PATH, "ValidLogin", 1, 1);
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUserName(un);
		
		loginpage.setPassword(pw);
		loginpage.clickLoginButton();
		
		ETTPage enterTimePage=new ETTPage(driver); 
		
		boolean res = enterTimePage.verifyLogoutLink(wait);
		
		Assert.assertTrue(res);
		
   
	
	}

}
