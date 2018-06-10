package com.trevorism.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author tbrooks
 */
class ReleasePluginTest {

    @Test
    void testApply() {
        Project project = createProject()
        assert project.plugins.findPlugin("com.trevorism.gradle-release-plugin")
    }

    static Project createProject(){
        Project project = ProjectBuilder.builder().withName("foo").build()
        project.with{
            apply plugin: 'com.trevorism.gradle-release-plugin'
        }
        return project
    }
}
