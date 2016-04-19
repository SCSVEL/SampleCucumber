package utils;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(		
		features = "tests"    //folder name contains the .feature files
		,glue = "steps"   //should be package name; if Runner class and steps are in same folder, no need to mention
		)

public class RunMyFeatureTests { }

/*
 * This Class is just a hook/trigger point to initiate tests. 
 * Cucumber.class implements junit runner internally.
 * Should not have any code here
*/