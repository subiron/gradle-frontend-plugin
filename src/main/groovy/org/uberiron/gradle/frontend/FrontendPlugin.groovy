package org.uberiron.gradle.frontend

import org.uberiron.gradle.frontend.task.Gulp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.uberiron.gradle.frontend.extensions.FrontendExtension
import org.uberiron.gradle.frontend.task.Grunt
import org.uberiron.gradle.frontend.task.InstallNodeAndNpm
import org.uberiron.gradle.frontend.task.Npm

public class FrontendPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("frontendConfig", FrontendExtension)
        project.task('InstallNodeAndNpm', type: InstallNodeAndNpm)
        project.task('npm', type: Npm)
        project.task('grunt', type: Grunt)
        project.task('gulp', type: Gulp)
    }
}
