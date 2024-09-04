package org.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
class TraceTest {

	@Test
	void exampleTraceTest(Page page) {
		page.context().tracing().start(
				new Tracing.StartOptions()
						   .setScreenshots(true)
						   .setSnapshots(true)
						   .setSources(true));

		page.navigate("https://playwright.dev/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Node.js")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Java").setExact(true)).click();
		assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();

		page.context().tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		//Drag and drop the created trace.zip file to the Playwright trace viewer https://trace.playwright.dev/
	}
}