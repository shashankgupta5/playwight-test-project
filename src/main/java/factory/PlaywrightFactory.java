package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import config.BrowserType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlaywrightFactory {

    public static Browser createPlaywrightBrowserInstance(String browserName, Playwright playwright) {
        BrowserType browserType = BrowserType.FIREFOX;
        try {
            browserType = BrowserType.valueOf(browserName.toUpperCase());
        } catch (Exception e) {
            logger.error("Unable to determine browser type, defaulting to {}", browserType);
        }

        return getBrowserFromConfiguration(browserType, playwright);
    }

    private static Browser getBrowserFromConfiguration(BrowserType browserType, Playwright playwright) {
        Browser browser = browserType.getBrowserObject(playwright);

        logger.info("[{}] browser started successfully", browserType.toString().toUpperCase());

        return browser;
    }

}
