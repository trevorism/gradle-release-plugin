package com.trevorism.plugin

import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

/**
 * @author tbrooks
 */
class Publishing {
    static void configure(Project project){
        project.apply plugin: "maven-publish"

        project.publishing {
            publications {
                snapshot(MavenPublication) {
                    groupId "com.trevorism"
                    artifactId project.name
                    version "${version}-SNAPSHOT"
                    from project.components.java
                }
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
                    credentials{
                        username = project.nexusUsername
                        password = project.nexusPassword
                    }
                }
                maven {
                    name "snapshot"
                    url project.snapshotRepository
                    credentials{
                        username = project.nexusUsername
                        password = project.nexusPassword
                    }
                }
            }
        }

        project.tasks.create("publishSnapshot") {
            dependsOn "publishSnapshotPublicationToSnapshotRepository"
            group = "publishing"
            description = "Runs the build and publishes a snapshot to nexus"
        }

        project.tasks.create("publishRelease") {
            dependsOn "publishReleasePublicationToReleaseRepository"
            group = "publishing"
            description = "Runs the build and publishes a release to nexus"
        }

    }
}
