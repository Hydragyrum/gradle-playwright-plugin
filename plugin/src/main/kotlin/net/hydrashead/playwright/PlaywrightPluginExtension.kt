package net.hydrashead.playwright

import org.gradle.api.provider.Property

interface PlaywrightPluginExtension {
    val toolVersion: Property<String>
}
