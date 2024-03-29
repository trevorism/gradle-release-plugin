package com.trevorism.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class ReleasePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.ext.releaseRepository = "https://maven.pkg.github.com/trevorism/${project.name}"
        Publishing.configure(project)
    }

}
