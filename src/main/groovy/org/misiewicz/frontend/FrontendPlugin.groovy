package org.misiewicz.frontend

import org.misiewicz.frontend.extensions.FrontendExtension
import org.misiewicz.frontend.task.Grunt
import org.misiewicz.frontend.task.Gulp
import org.misiewicz.frontend.task.InstallNodeAndNpm
import org.misiewicz.frontend.task.Npm
import org.gradle.api.Plugin
import org.gradle.api.Project

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
