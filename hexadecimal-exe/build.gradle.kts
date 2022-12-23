plugins {
    kotlin("multiplatform") version "1.7.20"
}

group = "kmm.example.hexadecimal-exe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native") { binaries { executable() } }
        hostOs == "Linux" -> linuxX64("native") { binaries { executable() } }
        isMingwX64 -> mingwX64("native") { binaries { executable() } }
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    sourceSets {
        val nativeMain by getting {
            dependencies {
                implementation(project(":hexadecimal"))
            }
        }
        val nativeTest by getting
    }
}
