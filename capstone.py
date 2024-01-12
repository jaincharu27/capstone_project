import sys

import pytest
from selenium import webdriver
from selenium.webdriver.edge.service import Service
from selenium.webdriver.common.by import By
from time import sleep

@pytest.fixture()
def initializeDriver():
    driver = webdriver.Edge(service=Service(executable_path='msedgedriver.exe'))
    return driver

def test_checkbox_fileUpload(initializeDriver):
    sys.stderr.write("Launch url")
    initializeDriver.get('https://the-internet.herokuapp.com/')
    initializeDriver.maximize_window()

    sys.stderr.write("Click on Checkboxes link")
    initializeDriver.find_element(By.LINK_TEXT, "Checkboxes").click()

    sys.stderr.write("Verify checkbox text 'Checkboxes'")
    actual_checkbox_page_text = initializeDriver.find_element(By.TAG_NAME, "h3").text
    expected_checkbox_page_text = "Checkboxes"
    assert expected_checkbox_page_text == actual_checkbox_page_text

    sys.stderr.write("verify 'checkbox 1' is not checked")
    checkbox1 = initializeDriver.find_element(By.XPATH, "//input[@type='checkbox'][1]")
    assert checkbox1.is_selected() == False, "Fail: checkbox 1 is found selected"

    sys.stderr.write("verify 'checkbox 2' is checked")
    checkbox2 = initializeDriver.find_element(By.XPATH, "//input[@type='checkbox'][2]")
    if checkbox2.text == "checkbox2":
        assert checkbox2.is_selected() == True, "Fail: checkbox2 not found selected"

    sys.stderr.write("go back to home page")
    initializeDriver.back()

    sys.stderr.write("click on File Upload link")
    initializeDriver.find_element(By.LINK_TEXT, "File Upload").click()

    sys.stderr.write("verify file upload text 'File Uploader'")
    actual_file_upload_text = initializeDriver.find_element(By.TAG_NAME, "h3").text
    expected_file_upload_text = "File Uploader"
    assert expected_file_upload_text == actual_file_upload_text

    sys.stderr.write("click on Choose File button & select file")
    initializeDriver.find_element(By.ID, "file-upload").send_keys('C:/Users/JCHARU/Downloads/test image.png')

    sys.stderr.write("click on upload button")
    initializeDriver.find_element(By.ID, "file-submit").click()

    sys.stderr.write("verify file upload text 'File Uploaded!'")
    actual_file_upload_text = initializeDriver.find_element(By.TAG_NAME, "h3").text
    expected_file_upload_text = "File Uploaded!"
    assert expected_file_upload_text == actual_file_upload_text

    sleep(1)
    initializeDriver.close()