package net.hydrashead.playwright

import org.gradle.api.provider.Property

interface PlaywrightPluginExtension {
    val url: Property<String>

    val toolVersion: Property<String>
}