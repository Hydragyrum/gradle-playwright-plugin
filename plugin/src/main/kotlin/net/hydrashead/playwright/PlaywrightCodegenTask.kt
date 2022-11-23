package net.hydrashead.playwright

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

open class PlaywrightCodegenTask() : DefaultTask() {
    var url: String = "https://playwright.dev"
        @Input
        get
        @Option(option = "url", description = "The Url to visit")
        set

    @TaskAction()
    fun exec() {
        val playwrightSourceSet = project.extensions.getByType(SourceSetContainer::class.java).named("playwright").get()
        project.javaexec {
            it.classpath = playwrightSourceSet.runtimeClasspath
            it.mainClass.set("com.microsoft.playwright.CLI")
            it.args = listOf("codegen", url)
        }
    }
}
