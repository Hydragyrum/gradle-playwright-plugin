package net.hydrashead.test.playwright

import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.string.shouldContain

class SampleTest : BehaviorSpec({
    Given("A playwright module") {
        val playwrightInst = Playwright.create()
        playwrightInst.use { playwright ->
            And("A Firefox Browser") {
                val browser =
                    playwright.firefox().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50.0))
                val page = browser.newPage()
                When("We navigate to Playwright.dev") {
                    page.navigate("https://playwright.dev/java")
                    Then("The page title contains Playwright Java") {
                        page.title() shouldContain "Playwright Java"
                    }
                }
            }
            And("A Chromium Browser") {
                val browser =
                    playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50.0))
                val page = browser.newPage()
                When("We navigate to Playwright.dev") {
                    page.navigate("https://playwright.dev/java")
                    Then("The page title contains Playwright Java") {
                        page.title() shouldContain "Playwright Java"
                    }
                }
            }
        }
    }
})