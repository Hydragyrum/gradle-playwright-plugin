/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package net.hydrashead.playwright

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * A simple functional test for the 'net.hydrashead.playwright.greeting' plugin.
 */
class PlaywrightPluginFunctionalTest {
    @get:Rule val tempFolder = TemporaryFolder()

    private fun getProjectDir() = tempFolder.root
    private fun getBuildFile() = getProjectDir().resolve("build.gradle")
    private fun getSettingsFile() = getProjectDir().resolve("settings.gradle")

    @Test fun `can run task`() {
        // Setup the test build
        getSettingsFile().writeText("")
        getBuildFile().writeText("""
plugins {
    id('java')
    id('net.hydrashead.gradle-playwright')
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

playwright {
    url = "playwright.dev"
}
""")

        // Run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("codegen")
        runner.withProjectDir(getProjectDir())
        val result = runner.build();

        // Verify the result
        assertTrue(result.output.contains("Hello from plugin 'net.hydrashead.playwright'"))
    }
}