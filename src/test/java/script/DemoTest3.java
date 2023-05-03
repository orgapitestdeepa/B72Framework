package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class DemoTest3 extends BaseTest
{
	@Test
	public void demoTest1() {
			
			Reporter.log(driver.getTitle(),true);	

	}
}
