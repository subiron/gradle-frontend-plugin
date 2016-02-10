package org.misiewicz.frontend.task;

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction;


public class Npm extends AbstractFrontEndTask {

    def Npm() {
        super()
        description 'Executes NPM task (need package.json location)'
    }

    @Input
    String npmArgs = "install"

    @Input
    String packageJsonPath = "${getWorkingDirectory().getPath()}/package.json"

    @InputFile
    def getPackageJson() {
        return project.file(packageJsonPath);
    }

    @TaskAction
    def run() {
        factory.getNpmRunner(proxyConfig).execute(npmArgs);
    }
}
