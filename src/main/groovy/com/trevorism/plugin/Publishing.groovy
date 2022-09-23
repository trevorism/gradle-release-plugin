package com.trevorism.plugin

import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

/**
 * @author tbrooks
 */
class Publishing {

    static void configure(Project project) {
        project.apply plugin: "maven-publish"

        project.publishing {
            publications {
                release(MavenPublication) {
                    groupId "com.trevorism"
                    artifactId project.name
                    version version
                    from project.components.java
                }
            }
            repositories {
                maven {
                    name "release"
                    url project.releaseRepository
                    credentials {
                        username = project.findProperty("github.user") ?: System.getenv("GITHUB_ACTOR")
                        password = project.findProperty("github.token") ?: System.getenv("GITHUB_TOKEN")
                    }
                }
            }
        }

        project.tasks.create("publishRelease") {
            dependsOn "publishReleasePublicationToReleaseRepository"
            group = "publishing"
            description = "Runs the build and publishes a release to github artifacts"
        }

    }
}
