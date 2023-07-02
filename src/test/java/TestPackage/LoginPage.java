package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.SetUpClass;
import Utilities.HashUtilities;

public class LoginPage extends SetUpClass {
	
	
	@Test(priority = 1)
		public void orangeUrl() throws Exception {
		getBrowser().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getBrowser().manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(dataProvider = "ExelData",priority = 2)
	public void loginDataprovider(String uname,String ppass) throws Exception {
		Thread.sleep(2000);
		getBrowser().findElement(By.xpath("//*[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input[@name='username']")).sendKeys(uname);
		getBrowser().findElement(By.xpath("//*[@class='oxd-input-group oxd-input-field-bottom-space']/div[2]/input[@name='password']")).sendKeys(ppass);
	}
	
	@DataProvider(name = "LoginData")
	public String[][] updateData() {
		
		String[][] arr = new String[2][2];
		arr[0][0]="aabb@gmail.com";
		arr[0][1]="11qq11qq";
		arr[1][0]="aabbcc@gmail.com";
		arr[1][1]="552566";
		
		return arr;
	}
	
	@DataProvider(name = "ExelData")
	public String[][] readData() throws Exception {
		String filepath = System.getProperty("user.dir") + "\\Reports\\DataFilesExcel.xlsx";
		String loginDataarr[][];
		HashUtilities hass = new HashUtilities(filepath);
		int rro = hass.getRows("EmpInfo");
		int colls = hass.getCells("EmpInfo", 1);

		loginDataarr = new String[rro][colls];
		for(int i=1;i<=rro;i++) {
			for(int c=0; c<colls;c++) {
				loginDataarr[i-1][c]= hass.getData("EmpInfo", i, c);
			}
		}
		return loginDataarr;
	}
	
}
