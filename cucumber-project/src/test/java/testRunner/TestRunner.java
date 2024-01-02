package testRunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions(
		features = "Feature", 
		glue = { "stepDefinition" })

@Test
public class TestRunner extends AbstractTestNGCucumberTests{

}
