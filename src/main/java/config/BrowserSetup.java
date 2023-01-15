package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public interface BrowserSetup {

    Browser getBrowserObject(Playwright playwright);
}
