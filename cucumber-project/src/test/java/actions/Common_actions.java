package actions;

import org.openqa.selenium.WebDriver;

import stepDefinition.Common_steps;

public class Common_actions {
	
	private WebDriver driver;
	Common_steps common_steps;
	
	public Common_actions(Common_steps common_steps) {
		this.driver = common_steps.getDriver();
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void go_back_to_home_page() {
		driver.navigate().back();
	}

}
