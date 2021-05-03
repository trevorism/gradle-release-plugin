package com.trevorism.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author tbrooks
 */
class ReleasePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        boolean hasNexusUsername = project.hasProperty("nexusUsername")
        boolean hasNexusPassword = project.hasProperty("nexusPassword")

        if(!hasNexusUsername){
            project.logger.warn("Property: nexusUsername was not configured. Publishing will not be possible.")
        }
        if(!hasNexusPassword){
            project.logger.warn("Property: nexusPassword was not configured. Publishing will not be possible.")
        }

        project.ext.snapshotRepository = "https://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-snapshots/"
        project.ext.releaseRepository = "https://trevorism-build.eastus.cloudapp.azure.com/nexus/repository/maven-releases/"

        if(project.hasProperty("snapshotRepositoryOverride")){
            project.ext.snapshotRepository = project.snapshotRepositoryOverride
        }

        if(project.hasProperty("releaseRepositoryOverride")){
            project.ext.releaseRepository = project.releaseRepositoryOverride
        }

        if(hasNexusUsername && hasNexusPassword) {
            Publishing.configure(project)
        }

    }

}
