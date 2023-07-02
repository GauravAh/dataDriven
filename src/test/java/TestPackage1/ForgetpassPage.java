package TestPackage1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BasePackage.SetUpClass;
import Utilities.HashUtilities;

public class ForgetpassPage extends SetUpClass {

	@Test(priority = 1)
	public void orangeForget() throws Exception {
		getBrowser().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getBrowser().manage().window().maximize();
		Thread.sleep(3000);
		getBrowser().findElement(By.cssSelector("form.oxd-form>div:nth-of-type(4)>p")).click();
		Thread.sleep(3000);

		ForgetpassPage obj = new ForgetpassPage();
		HashMap<Integer, String> kk = obj.restPass();
		for (int i = 1; i <= kk.size(); i++) {
			getBrowser().findElement(By.cssSelector("div.oxd-form-row>div>div>input[name='username']"))
					.sendKeys(kk.get(i));
		} 

	/*	HashUtilities hh = new HashUtilities();
		Map<String, String> mapss = hh.readHash();
		for(Map.Entry m : mapss.entrySet()) {
			String eemai = m.getValue().toString();
			getBrowser().findElement(By.cssSelector("div.oxd-form-row>div>div>input[name='username']")).sendKeys(eemai);
		} */
	} 

	public HashMap<Integer, String> restPass() {
		HashMap<Integer, String> hashfForget = new HashMap<Integer, String>();
		hashfForget.put(1, "abc@gmail.com");
		hashfForget.put(2, "abcd@gmail.com");
		hashfForget.put(3, "abcde@gmail.com");

		return hashfForget;

	}

}
