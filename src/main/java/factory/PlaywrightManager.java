package factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import config.PropertyReader;

public class PlaywrightManager {

    private static ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> threadLocalBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static Playwright getPlaywright() {
        return threadLocalPlaywright.get();
    }

    public static Browser getBrowser() {
        return threadLocalBrowser.get();
    }

    public static BrowserContext getBrowserContext() {
        return threadLocalBrowserContext.get();
    }

    public static Page getPage() {
        return threadLocalPage.get();
    }

    public static Page createNewInstance() {
        var browserName = PropertyReader.getBrowserName();

        threadLocalPlaywright.set(Playwright.create());
        threadLocalBrowser.set(PlaywrightFactory.createPlaywrightBrowserInstance(browserName, getPlaywright()));
        threadLocalBrowserContext.set(getBrowser().newContext());
        threadLocalPage.set(getBrowserContext().newPage());

        return getPage();
    }

}
