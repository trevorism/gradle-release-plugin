package com.trevorism.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author tbrooks
 */
class ReleasePluginTest {


    @Test
    void "canoncial example"() {
        Project project = createProject()
        assert project.plugins.findPlugin("com.trevorism.gradle.release")
        assert project.tasks.findByPath("publishSnapshot")
        assert project.tasks.findByPath("publishRelease")

        assert "https://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-snapshots/" == project.snapshotRepository
        assert "https://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-releases/" == project.releaseRepository

        assert project.publishing.publications.size() == 2
    }

    @Test
    void "if the project does not have the right properties, publishing tasks are not added"() {
        Project project = createProjectWithoutProperties()
        assert project.plugins.findPlugin("com.trevorism.gradle.release")
        assert !project.tasks.findByPath("publishSnapshot")
        assert !project.tasks.findByPath("publishRelease")
    }


    @Test
    void "repository overrides"() {
        Project project = createProjectWithRepositoryOverrides()
        assert project.plugins.findPlugin("com.trevorism.gradle.release")

        assert "foo" == project.snapshotRepository
        assert "bar" == project.releaseRepository
    }

    static Project createProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{
            project.ext.nexusUsername = "test"
            project.ext.nexusPassword = "test"
            apply plugin: 'java'
            apply plugin: 'com.trevorism.gradle.release'

        }
        return project
    }

    static Project createProjectWithoutProperties(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{
            apply plugin: 'com.trevorism.gradle.release'

        }
        return project
    }

    static Project createProjectWithRepositoryOverrides(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{

            project.ext.snapshotRepositoryOverride = "foo"
            project.ext.releaseRepositoryOverride = "bar"

            apply plugin: 'com.trevorism.gradle.release'

        }
        return project
    }
}
