@file:Suppress("TrailingComma", "ConvertLambdaToReference")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  id("org.jetbrains.intellij") version "1.3.0"
  kotlin("jvm") version "1.6.0"
}

group = "com.github.lppedd"
version = "0.8.3"

repositories {
  mavenCentral()
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  testImplementation("junit:junit:4.13.2")
}

intellij {
  version.set("2021.1.3")
  type.set("IU")
  downloadSources.set(true)
  pluginName.set("idea-conventional-commit")
  plugins.set(listOf(
      "java",
      "org.jetbrains.plugins.go:211.7628.1",
      "JavaScriptLanguage",
      "Pythonid:211.7628.8",
      "com.jetbrains.php:211.7442.50"
  ))
}

configure<JavaPluginExtension> {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
  val kotlinSettings: KotlinCompile.() -> Unit = {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += listOf(
        "-Xno-call-assertions",
        "-Xno-receiver-assertions",
        "-Xno-param-assertions",
    )
  }

  compileKotlin(kotlinSettings)
  compileTestKotlin(kotlinSettings)

  patchPluginXml {
    version.set(project.version.toString())
    sinceBuild.set("201.6668")
    untilBuild.set("")

    val projectPath = projectDir.path
    pluginDescription.set((File("$projectPath/plugin-description.html").readText(Charsets.UTF_8)))
    changeNotes.set((File("$projectPath/change-notes/${version.get().replace('.', '_')}.html").readText(Charsets.UTF_8)))
  }
}
