# Gradle Playwright Plugin
A simple Plugin to use Playwright in a gradle JVM project

## Usage

In the plugins block, import the `net.hydrashead.gradle-playwright` plugin: 

```kotlin
plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    id("net.hydrashead.gradle-playwright") version "0.0.2"
}
```

The plugin will automagically import the java plugin if it s not already loaded in order to create a new sourceset.

Add your tests to the `playwright` source set and use the `:playwrightTest` command to launch the tests.

## Example

Using the Kotest library as an example:

```kotlin
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
```

## Config

Use the `playwright` block in the build.gradle.

Available options are:

- `toolVersion`: Sets the playwright version to use. Defaults to `1.27.0`

```kotlin
playwright {
    toolVersion.set("1.27.0")
}
```

## Contributing

Coming soon.