# gradle-release-plugin : Gradle plugin for creating a release, driven by properties
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/gradle-release-plugin)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/gradle-release-plugin)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/gradle-release-plugin)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/gradle-release-plugin)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/gradle-release-plugin)


## Perform a release in:

* Nexus -- Publishes the artifact to the release repository

## Usage

```$xslt
buildscript {
    repositories {
        maven {
            url uri("http://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-releases")
        }
    }
    dependencies {
        classpath 'com.trevorism:gradle-release-plugin:0.4.0'
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