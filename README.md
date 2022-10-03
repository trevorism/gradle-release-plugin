# gradle-release-plugin
![Build](https://github.com/trevorism/gradle-release-plugin/actions/workflows/build.yml/badge.svg)
![GitHub last commit](https://img.shields.io/github/last-commit/trevorism/gradle-release-plugin)
![GitHub language count](https://img.shields.io/github/languages/count/trevorism/gradle-release-plugin)
![GitHub top language](https://img.shields.io/github/languages/top/trevorism/gradle-release-plugin)

This plugin publishes the default software component to github packages.

Current [Version](https://github.com/trevorism/gradle-release-plugin/releases/latest)

## Usage

```groovy
buildscript {
    repositories {
        mavenCentral()
        maven {
            url uri("https://maven.pkg.github.com/trevorism/gradle-release-plugin")
            credentials {
                username = findProperty("github.user") ?: System.getenv("GITHUB_ACTOR")
                password = findProperty("github.token") ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    dependencies {
        classpath 'com.trevorism:gradle-release-plugin:0.7.0'
    }
}

apply plugin: "com.trevorism.gradle.release"
```

The github username and PAT should be supplied as credentials.

## About

About me -- https://www.trevorism.com