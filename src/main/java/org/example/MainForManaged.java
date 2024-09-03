package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class MainForManaged {
    private static final String TEMP_PATH = "C:/dev/temp";

    public static void main(String[] args) {

        //put this options in launch config alternatively
        System.setProperty("playwright.driver.tmpdir", TEMP_PATH);

        try (Playwright playwright = Playwright.create()) {
            BrowserType.LaunchOptions browserOptions = new BrowserType.LaunchOptions();
            browserOptions.setHeadless(false);
            Browser browser = playwright.chromium().launch(browserOptions);

            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
        }
    }
}