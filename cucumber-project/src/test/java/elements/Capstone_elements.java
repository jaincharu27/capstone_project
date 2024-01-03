package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Capstone_elements {
	
	WebDriver driver;
	
	@FindBy(linkText = "A/B Testing") public WebElement AB_Testing_link;
	@FindBy(linkText = "Dropdown") public WebElement Dropdown_link;
	@FindBy(linkText = "Frames") public WebElement Frames_link;
	@FindBy(linkText = "Checkboxes") public WebElement Checkboxes_link;
	@FindBy(linkText = "File Upload") public WebElement File_Upload_link;
	@FindBy(tagName = "h3") public WebElement text_AB_Test_Control;
	@FindBy(tagName = "h3") public WebElement text_checkboxes;
	@FindBy(id = "dropdown") public WebElement dropdown;
	@FindBy(linkText = "Nested Frames") public WebElement Nested_Frames_link;
	@FindBy(linkText = "iFrame") public WebElement iFrame_link;
	@FindBy(xpath = "//input[@type='checkbox'][1]") public WebElement checkbox1;
	@FindBy(xpath = "//input[@type='checkbox'][2]") public WebElement checkbox2;
	@FindBy(id = "file-upload") public WebElement choose_file_button;
	@FindBy(id = "file-submit") public WebElement upload_button;
	@FindBy(tagName = "h3") public WebElement text_file_upload;
	@FindBy(tagName = "h3") public WebElement text_file_uploaded;
	
	public Capstone_elements(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
