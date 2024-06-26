package utilities;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

    private final DriverManager driverManager = new DriverManager();

    @BeforeAll
    public static void beforeAllHook() {
        FileManager.deletePreviousEvidence();
    }

    @Before
    public void masterSetUp() {
        driverManager.buildDriver();
    }

    @After
    public void masterTearDown(Scenario scenario) {
        switch (scenario.getStatus()) {
            case FAILED, SKIPPED -> {
                FileManager.getScreenshot(scenario.getName());
                FileManager.getPageSource(scenario.getName());
                FileManager.attachScreenshot(scenario);
                FileManager.attachPageSource(scenario);
            }
        }
        driverManager.killDriver();
    }
}
