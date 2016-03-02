package org.uberiron.gradle.frontend.task;

import org.apache.commons.lang3.StringUtils
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;

public class Gulp extends AbstractFrontEndTask {

    public Gulp() {
        super()
        description 'Executes GULP tasks'
    }

    String gulpArgs = StringUtils.EMPTY;

    @InputDirectory
    def getInputDir() {
        getWorkingDirectory();
    }

    @OutputDirectory
    def getOutputDir() {
        getWorkingDirectory();
    }

    @TaskAction
    def run() {
        factory.getGulpRunner().execute(gulpArgs);
    }
}
