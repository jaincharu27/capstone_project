package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import actions.Common_actions;
import actions.Capstone_actions;

public class Steps {

	WebDriver driver;
	Select dropdown;
	
	Common_actions common_actions;
	Capstone_actions login_actions;
	
	public Steps(Common_actions common_actions, Capstone_actions login_actions) {
		this.common_actions = common_actions;
		this.login_actions = login_actions;
	}
	
	@Given("launch url")
	public void launch_url() {
		common_actions.getURL("https://the-internet.herokuapp.com/");
	}
	
	@Then("verify title")
	public void verify_title() {
		String page_title = common_actions.getTitle();
		Assert.assertEquals(page_title, "The Internet");
	}
	
	@When("click on A\\/B Testing link")
	public void click_on_link() {
		login_actions.click_AB_Testing_link();
	}
	
	@When("click on Dropdown link")
	public void click_on_dropdown_link() {
	    login_actions.click_Dropdown_link();
	}
	
	@When("click on Checkboxes link")
	public void click_on_checkboxes_link() {
	    login_actions.click_Checkboxes_link();
	}

	@When("click on Frames link")
	public void click_on_frames_link() {
	    login_actions.click_Frames_link();
	}

	@When("click on File Upload link")
	public void click_on_file_upload_link() {
	    login_actions.click_File_Upload_link();
	}

	@Then("verify main headline text {string}")
	public void verify_main_headline_text(String string) {
		String page_headline = login_actions.get_text_AB_Test_Control();		
		Assert.assertEquals(string, page_headline);
	}
	
	@Then("verify text {string}")
	public void verify_text(String string) {
		String page_headline = login_actions.get_text_Checkboxes();		
		Assert.assertEquals(string, page_headline);
	}

	@When("go back to home page")
	public void go_back_to_home_page() {
		common_actions.go_back_to_home_page();
	}
	
	@When("select {string} value from dropdown")
	public void select_value_from_dropdown(String string) {
		login_actions.select_value_from_dropdown(string);
	}
	
	@Then("confirm {string} is selected or not")
	public void confirm_it_is_selected_or_not(String string) {
		
		if(login_actions.is_dropdown_option_text_is_same(string) && login_actions.is_dropdown_option_is_selected())
			Assert.assertTrue(true, "Option 1 is in selection");
		else
			System.out.println("Other option is in selection");
	}
	
	@Then("verify {string} & {string} links are presented on page")
	public void verify_links_are_presented_on_page(String string, String string2) {
		if(login_actions.link_Nested_Frames_isDisplayed());		
			Assert.assertTrue(true, string+" is presented on page");
		if(login_actions.link_iFrames_isDisplayed());		
			Assert.assertTrue(true, string2+" is presented on page");
	}
	
	@Then("verify {string} is not checked")
	public void verify_is_not_checked(String string) {
		if(login_actions.checkbox1_isNotSelected());		
		Assert.assertFalse(false, string+" is not selected on page");		
	}
	
	@Then("verify {string} is checked")
	public void verify_is_checked(String string) {
		if(login_actions.checkbox2_isSelected() && login_actions.is_checkbox_text_is_same(string));		
		Assert.assertTrue(true, string+" is selected on page");		
	}
	
	@Then("click on Choose File button")
	public void click_on_choose_file_button() {
		System.out.println("Please make sure to update file path as per your system!!n");
		login_actions.filePath_to_choose_file("C:\\Users\\JCHARU\\Downloads\\test image.png");
	}
	
	@Then("click on upload button")
	public void click_on_upload_button() {
		login_actions.click_on_upload_button();
	}
	
}
