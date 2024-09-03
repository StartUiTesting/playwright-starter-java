package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright(ExampleTest.ExampleOptions.class)
class ExampleTest {

	public static final String VIDEO_DIR = "video";

	public static class ExampleOptions implements OptionsFactory {
		@Override
		public Options getOptions() {
			return new Options() //some example options
					.setHeadless(true)
					.setLaunchOptions(new BrowserType.LaunchOptions().setSlowMo(1000))
					.setContextOptions(new Browser.NewContextOptions().setRecordVideoDir(Path.of(VIDEO_DIR)))
					.setIgnoreHTTPSErrors(true);
		}
	}

	@Test
	void exampleTest(Page page) {
		page.navigate("https://playwright.dev/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Node.js")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Java").setExact(true)).click();
		assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
	}
}