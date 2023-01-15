package listener;

import com.microsoft.playwright.Page;
import common.Constants;
import factory.PlaywrightManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.nio.file.Paths;

@Slf4j
public class SimpleTestNGSuiteListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        var path = Constants.BASE_USER_DIR + "screenshots/" + System.currentTimeMillis() + ".png";
        var page = PlaywrightManager.getPage();

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        logger.info("Saved screenshot for [{}] test failure at [{}]", iTestResult.getTestContext().getName(), path);

        super.onTestFailure(iTestResult);
    }
}
