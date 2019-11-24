# gradle-release-plugin : Gradle plugin for creating a release, driven by properties
![Jenkins](https://img.shields.io/jenkins/build/http/trevorism-build.eastus.cloudapp.azure.com/gradle-release-plugin)
![Jenkins Coverage](https://img.shields.io/jenkins/coverage/jacoco/http/trevorism-build.eastus.cloudapp.azure.com/gradle-release-plugin)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/gradle-release-plugin)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/gradle-release-plugin)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/gradle-release-plugin)


## Description:

This plugin publishes the default software component to a local nexus server: [Nexus](http://trevorism-build.eastus.cloudapp.azure.com/nexus/)

## Prerequisites

Assumes the credentials are stored as properties. The can be stored in ~/.gradle/gradle.properties:

```properties
nexusUsername=username
nexusPassword=pass
```

## Usage

```groovy
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

Save an artifact using one of the following commands:

`gradle publishSnapshot`

`gradle publishRelease`

## About

About me -- https://www.trevorism.com