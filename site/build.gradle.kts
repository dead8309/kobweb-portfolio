import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.meta

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    // alias(libs.plugins.kobwebx.markdown)
}

group = "org.example.portfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")
            head.add {
                meta("og:image", "/banner.png",)
                meta(name = "og:image:type", content = "image/png")
                meta(name = "og:image:width", content = "1200")
                meta(name = "og:image:height", content = "630")
                meta(name = "og:site_name", content = "Kobweb Portfolio")
                meta(name = "og:type", content = "website")
                meta(name = "twitter:site", content = "Kobweb Portfolio")
                meta(name = "twitter:title", content = "Kobweb Portfolio")
                meta(name = "twitter:description", content = "A sample portfolio site made from kotlin using kobweb🗿")
                meta(name = "twitter:card", content = "summary_large_image")
                meta(name = "twitter:image:src", content = "/banner.png")
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("portfolio", includeServer = true)
    jvmToolchain(11) // Kobweb server should use at least Java 11

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
                // implementation(libs.kobwebx.markdown)
             }
        }
        val jvmMain by getting {
            dependencies {
                implementation(libs.kobweb.api)
             }
        }
    }
}