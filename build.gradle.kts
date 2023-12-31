// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    dependencies{
        val nav_version = "2.7.5"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath(kotlin("gradle-plugin", version = "1.9.20"))

    }
}
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

    kotlin("kapt") version "1.9.20"
    kotlin("jvm") version "1.9.20" apply false

}