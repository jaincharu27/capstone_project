package actions;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import elements.Capstone_elements;
import stepDefinition.Common_steps;

public class Capstone_actions {
	
	private WebDriver driver;
	Capstone_elements login_elements;
	Select dropdown;
	
	public Capstone_actions(Common_steps common_steps){
		this.driver = common_steps.getDriver();
		login_elements = new Capstone_elements(driver);
	}
	
	public void click_AB_Testing_link() {
		login_elements.AB_Testing_link.click();
	}

	public String get_text_AB_Test_Control() {
		return login_elements.text_AB_Test_Control.getText();
	}

	public void click_Dropdown_link() {
		login_elements.Dropdown_link.click();
	}

	public void click_Checkboxes_link() {
		login_elements.Checkboxes_link.click();
	}
	
	public String get_text_Checkboxes() {
		return login_elements.text_checkboxes.getText();
	}
	
	public void click_Frames_link() {
		login_elements.Frames_link.click();
	}
	
	public void click_File_Upload_link() {
		login_elements.File_Upload_link.click();
	}

	public String get_text_File_Upload() {
		return login_elements.text_file_upload.getText();
	}

	public String get_text_File_Uploaded() {
		return login_elements.text_file_uploaded.getText();
	}

	public void click_on_upload_button() {
		login_elements.upload_button.click();
	}

	public void select_value_from_dropdown(String option) {
		dropdown = new Select(login_elements.dropdown);
		dropdown.selectByVisibleText(option);
	}
	
	public boolean is_dropdown_option_text_is_same(String option) {
		if (dropdown.getFirstSelectedOption().getText().equalsIgnoreCase(option)) {
			return true;			
		}
		else
			return false;

	}

	public boolean is_dropdown_option_is_selected() {
		if(dropdown.getFirstSelectedOption().isSelected())	
			return true;
		else
			return false;
	}
	
	public boolean link_Nested_Frames_isDisplayed() {
		if(login_elements.Nested_Frames_link.isDisplayed())	
			return true;
		else
			return false;
	}

	public boolean link_iFrames_isDisplayed() {
		if(login_elements.iFrame_link.isDisplayed())	
			return true;
		else
			return false;
	}

	public boolean checkbox1_isNotSelected() {
		if(login_elements.checkbox1.isSelected())	
			return true;
		else
			return false;
	}

	public boolean checkbox2_isSelected() {
		if(login_elements.checkbox2.isSelected())	
			return true;
		else
			return false;
	}
	
	public boolean is_checkbox_text_is_same(String option) {
		if (login_elements.checkbox2.getText().equalsIgnoreCase(option)) {
			return true;			
		}
		else
			return false;

	}
	
	public void filePath_to_choose_file(String filepath) {
		login_elements.choose_file_button.sendKeys(filepath);
	}

}
