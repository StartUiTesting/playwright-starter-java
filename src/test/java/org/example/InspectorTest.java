package org.example;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
class InspectorTest {

	/**
	 * Launch this test with the following command:
	 * PWDEBUG=1 PLAYWRIGHT_JAVA_SRC=src/test/java mvn test -Dtest=org.example.InspectorTest
	 *
	 * For more information visit https://playwright.dev/java/docs/debug
	 */
	@Test
	void exampleInspectorTest(Page page) {
		page.pause();
		page.navigate("https://playwright.dev/");
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Node.js")).click();
		page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Java").setExact(true)).click();
		assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Installation"))).isVisible();
	}
}