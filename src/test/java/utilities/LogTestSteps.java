package utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import static dataReader.DataFunction.Browser;
import static dataReader.DataFunction.Url;

public class LogTestSteps extends BaseClass {


    @Before
    public void beforeHook(Scenario scenario) throws Exception {


        this.scenario = scenario;
        System.out.println("Testing the scenario => " +scenario.getName());
        System.out.println(scenario.getId());

        launchbrowser(Url,Browser);
        //*System.out.println("Before method");
        // launchbrowser();
        //  DataFunction.dataFunction("Credentials",1);
    }
    @After
    public void tearDown(){
        driver.close();
        repo.flush();
    }

}
