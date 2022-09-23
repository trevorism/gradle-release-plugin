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

        def actor = project.findProperty("github.user") ?: System.getenv("GITHUB_ACTOR")
        def token = project.findProperty("github.token") ?: System.getenv("GITHUB_TOKEN")

        if (!actor || !token) {
            project.logger.warn("Unable to publish project with missing credentials. Set environment variables for GITHUB_ACTOR and GITHUB_TOKEN")
        } else {
            Publishing.configure(project)
        }
    }

}
