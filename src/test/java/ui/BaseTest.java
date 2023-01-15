package ui;

import factory.PlaywrightManager;
import listener.SimpleTestNGSuiteListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners({SimpleTestNGSuiteListener.class})
public class BaseTest {

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        PlaywrightManager.createNewInstance();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        PlaywrightManager.getPage().close();
        PlaywrightManager.getBrowser().close();
        PlaywrightManager.getPlaywright().close();
    }
}
