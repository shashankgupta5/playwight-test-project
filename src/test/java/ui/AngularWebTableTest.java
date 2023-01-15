package ui;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import factory.PlaywrightManager;
import lombok.extern.slf4j.Slf4j;
import org.testng.TestException;
import org.testng.annotations.Test;

@Slf4j
public class AngularWebTableTest extends BaseTest {

    @Test
    public void scrapTableData() {
        Page page = PlaywrightManager.getPage();
        try {
            page.navigate("https://www.primefaces.org/primeng/table");

            Locator rows = page.locator("table[role='table'] tbody tr");
            rows.locator(":scope").allInnerTexts().forEach(logger::info);
            rows.locator(":scope", new Locator.LocatorOptions().setHasText(" Sage Wieser ")).locator(".p-checkbox-box").click();
        } catch (Exception e) {
            logger.error("Test Failed :( " + e.getMessage());
            throw new TestException(e.getMessage());
        }
    }
}
