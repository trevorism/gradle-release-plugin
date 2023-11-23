package com.trevorism.plugin

import org.gradle.api.Project
import org.gradle.api.internal.plugins.PluginApplicationException
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author tbrooks
 */
class ReleasePluginTest {

    @Test
    void "canonical example"() {
        Project project = createProject()
        assert project.plugins.findPlugin("com.trevorism.gradle.release")
        assert project.tasks.findByPath("publishRelease")

        assert "https://maven.pkg.github.com/trevorism/foo" == project.releaseRepository

        assert project.publishing.publications.size() == 1
    }

    static Project createProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{
            apply plugin: 'java'
            apply plugin: 'com.trevorism.gradle.release'
        }
        return project
    }

    @Test(expected = Exception)
    void "cannot publish non-java projects"() {
        Project project = createNonJavaProject()
        assert project.plugins.findPlugin("com.trevorism.gradle.release")
    }

    static Project createNonJavaProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{
            apply plugin: 'com.trevorism.gradle.release'
        }
        return project
    }

}
