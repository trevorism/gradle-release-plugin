# gradle-release-plugin : Gradle plugin for creating a release, driven by properties

## Perform a release in:

* Nexus -- Publishes the artifact to the release repository

## Usage

```$xslt
buildscript {
    repositories {
        maven {
            url uri("http://trevorism-build.eastus.cloudapp.azure.com/nexus/maven-releases")
        }
    }
    dependencies {
        classpath 'com.trevorism:gradle-release-plugin:0.2.0'
    }
}

plugins{
    id "java"
}

apply plugin: "com.trevorism.gradle.release"
```

`gradle publishSnapshot`

`gradle publishRelease`


Plugin Information -- https://plugins.gradle.org/plugin/com.trevorism.gradle-release-plugin

About me -- http://www.trevorism.com