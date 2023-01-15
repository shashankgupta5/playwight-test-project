package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;

public enum BrowserType implements BrowserSetup {
    FIREFOX() {
        @Override
        public Browser getBrowserObject(Playwright playwright) {
            return playwright.firefox().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
        }
    },
    CHROME() {
        @Override
        public Browser getBrowserObject(Playwright playwright) {
            return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(false));
        }

    },
    CHROME_HEADLESS() {
        @Override
        public Browser getBrowserObject(Playwright playwright) {
            return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions()
                    .setChannel("chrome")
                    .setHeadless(true));
        }
    },
    CHROMIUM() {
        @Override
        public Browser getBrowserObject(Playwright playwright) {
            return playwright.chromium().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
        }
    },
    WEB_KIT() {
        @Override
        public Browser getBrowserObject(Playwright playwright) {
            return playwright.webkit().launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
        }
    }
}
