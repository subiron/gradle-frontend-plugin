package org.misiewicz.frontend.task;

import org.apache.commons.lang3.StringUtils
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction;

public class Grunt extends AbstractFrontEndTask {

    public Grunt() {
        super();
        description 'Executes GRUNT task'
    }

    @Input
    String gruntArgs = StringUtils.EMPTY;

    @InputDirectory
    def getInputDir() {
        getWorkingDirectory();
    }

    @OutputDirectory
    def getOutputDir() {
        getWorkingDirectory();
    }

    @TaskAction
    public run() {
        factory.getGruntRunner().execute(gruntArgs)
    }

}
