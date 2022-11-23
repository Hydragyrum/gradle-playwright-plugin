/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package net.hydrashead.playwright

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'net.hydrashead.gradle-playwright' plugin.
 */
class PlaywrightPluginTest {
    @Test fun `plugin registers codegen task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("java")
        project.plugins.apply("net.hydrashead.gradle-playwright")

        // Verify the result
        assertNotNull(project.tasks.findByName("codegen"))
    }

    @Test fun `plugin registers test task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("java")
        project.plugins.apply("net.hydrashead.gradle-playwright")

        // Verify the result
        assertNotNull(project.tasks.findByName("playwrightTest"))
    }
}
