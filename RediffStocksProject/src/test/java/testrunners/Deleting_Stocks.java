package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/Delete.feature",glue="stepdefinitions",dryRun=false , 
plugin= {"com.cucumber.listener.ExtentCucumberFormatter:Reports/stocksresult.html"})
public class Deleting_Stocks  extends AbstractTestNGCucumberTests
{

}
