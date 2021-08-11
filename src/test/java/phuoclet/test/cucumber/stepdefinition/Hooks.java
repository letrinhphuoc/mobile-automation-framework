package phuoclet.test.cucumber.stepdefinition;

import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import phuoclet.test.cucumber.MobileApplicationHooks;

public class Hooks {
    @Inject
    private MobileApplicationHooks mobile;
    @Before(value = "@Mobile")
    public void setupScenarioMobile() {
        mobile.start();
    }

    @After(value = "@Mobile")
    public void teardownScenarioMobile(Scenario scenario) {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName();
            String imageName = scenarioName + ".png";
            scenario.attach(mobile.takeScreenshotMobile(imageName), "image/png", scenarioName);
        }
        mobile.quit();

    }

}
