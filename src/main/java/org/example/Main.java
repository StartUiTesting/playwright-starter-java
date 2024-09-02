package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

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